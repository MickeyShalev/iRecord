/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package iRecord;

import Validators.PositiveValidator;
import entities.*;
import iRecord.Controller.XMLManager;
import iRecord.Validators.CharValidator;
import java.util.Date;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import iRecord.utilities.EAuth;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class iRecord {
    
    private static DBManager DB;
    private static Person loggedUser = null;
    private static String fileName = "iReportLogger";
    private static FileWriter logFile;
    private static PrintStream logWriter;
    private static Person admin;
    
    
    
    public iRecord() {
        //Reset log
        try {
            SimpleDateFormat sdfDate = new SimpleDateFormat("ddM_hhmm");
            Date now = new Date();
            String strDate = sdfDate.format(now);
            
            logWriter = new PrintStream(new File(fileName+"_"+strDate+".log"));
            //System.setErr(logWriter);
            //System.setOut(logWriter);
            logWriter.print("=================  iRecord v1.0 - " + new Date() + " ==================" + System.getProperty("line.separator"));
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Cannot write to log file!");
            System.exit(0);
        }
        
        //Initiate DB
        init();
        
    }
    
    /**
     * This class import artists' dates XML from HandsInAir
     * @param id
     */
    public static void importXML(String id) {
        
    }
    
    public static DBManager getDB() {
        return DB;
    }
    
    public static void setDB(DBManager DB) {
        iRecord.DB = DB;
    }
    
    public static Person getLoggedUser() {
        return loggedUser;
    }
    
    public static void setLoggedUser(Person loggedUser) {
        iRecord.loggedUser = loggedUser;
    }
    
    /**
     * Initiates a DB Connection
     */
    public void init() {
        admin  = new Person("Admin", "Admin", "Admin", "Admin" ,EAuth.Administrator);
        
        try {
            log("Attempting connection to MS Access DB");
            DB = new DBManager();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(iRecord.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } catch (SQLException ex) {
            Logger.getLogger(iRecord.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        log("Successfully connected to MS Access DB.");
    }
    
    
    
    
    /**
     * Internal Logging
     *
     */
    public static void log(String str) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        logWriter.print(strDate + "\t" + str + System.getProperty("line.separator"));
        logWriter.flush();
        
    }
    
    
    /**
     * This method gets id and password and validates username and password using sql query
     * if user was found he will be converted to Object for main gui operations
     * suspended user can't login until admin release
     * @param id
     * @param pass
     * @return true if user is allowed to enter to the system
     * @throws SQLException
     */
    public static boolean logIn(String id, String pass) throws SQLException {
        ResultSet tmp = null;
        log("Attempting login using " + id + "/" + pass);
        
        //check if admin
        if(id.equals(admin.getID()) && pass.equals(admin.getPassword())){
            loggedUser = admin;
            return true;
        }
        
        //check is studio rep is tring to login
        if (CharValidator.isNumber(id)){
            if (tryAsSrudio(id, pass)){
                return true;
            }
        }
        
        if (id.length() < 3) return false;
        //System.out.println(id.substring(0,2));
        //Artist is attempting to login
        if (id.substring(0, 2).equals("AR") || id.equals("admin")){
            tmp = iRecord.DB.query("SELECT * FROM Artists WHERE ArtistID=\"" + id + "\" AND strPasswd=\"" + pass + "\"");
            
            //user is in DB
            if (tmp.next()) {
                if (tmp.getString(1).length() > 0) {
                    
                    String ID = tmp.getString("ArtistID");
                    String strStageName = tmp.getString("StageName");
                    String strEmailaddr = tmp.getString("sEmail");
                    String strPasswd = tmp.getString("strPasswd");
                    java.sql.Date expireDate = tmp.getDate("dateExpired");
                    java.util.Date d = new java.util.Date(expireDate.getTime());
                    Person p = new Artist(ID, strStageName, strEmailaddr, strPasswd, expireDate, EAuth.Artist);
                    setLoggedUser(p);
                    log("Artist logged in");
                    
                    //check if suspended
                    if (d.after(new java.util.Date())) {
                        return false;
                    }
                    
                    return true;
                }
                
            }
            //user is not on DB - search in HIA XML
            else{
                ArrayList<String[]> artists = XMLManager.importArtistsXML();
                for (String[] s : artists){
                    if (!id.equals(s[0])) continue;
                    Person a = new Artist(s[0]);
                    a.setStageName(s[1]);
                    a.setEmail(s[2]);
                    a.setUserAuth(EAuth.HIA_Artist);
                    setLoggedUser(a);
                    return true;
                }
            }
        }
        
        //Freelancer is attempting to login
        else if (id.substring(0, 2).equals("FL")){
            tmp = iRecord.DB.query("SELECT * FROM Freelancer WHERE FreelancerID=\"" + id + "\" AND password=\"" + pass + "\"");
            
            if (tmp.next()) {
                if (tmp.getString(1).length() > 0) {
                    
                    String ID = tmp.getString("FreelancerID");
                    String stageName = tmp.getString("StageName");
                    String fname = tmp.getString("firstName");
                    String lname = tmp.getString("lastName");
                    String email = tmp.getString("strEmail");
                    String password = tmp.getString("Password");
                    java.sql.Date date = tmp.getDate("birthdate");
                    int status = tmp.getInt("Status");
                    //System.err.println("Date: " + expireDate);
                    Person p = new Freelancer(ID, fname, lname, stageName, email, password,  status,  date);
                    // ID,  firstName,  lastName,  stageName,  email,  password,  status,  birthdate
                    if (status == 0){
                        return false;
                    }
                    setLoggedUser(p);
                    log("Freelancer logged in");
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    
    /**s
     * This method checks if a login attempt is from studio rep
     * @param id
     * @param pass
     * @return
     * @throws SQLException
     */
    private static boolean tryAsSrudio(String id, String pass) throws SQLException{
        
        int sid = (int) PositiveValidator.stringToNum(id);
        if (sid < 0) return false;
        ResultSet tmp = iRecord.DB.query("SELECT * FROM Studio WHERE Studioid=" + sid + " AND password=\"" + pass + "\"");
        
        if (tmp.next()) {
            if (tmp.getString(1).length() > 0) {
                
                String ID = tmp.getString("studioid");
                String stageName = tmp.getString("sname");
                String email = tmp.getString("semail");
                String password = tmp.getString("Password");
                //System.err.println("Date: " + expireDate);
                Person p = new Person(ID, stageName, password, EAuth.Studio_Representative);
                // ID,  firstName,  lastName,  stageName,  email,  password,  status,  birthdate
                
                setLoggedUser(p);
                log("Studio logged in");
                return true;
            }
            
        }
        
        
        return false;
    }
    
    
    public static String getID(String str) {
        
        try {
            String tmp[] = str.split("\\(");
            tmp = tmp[1].split("\\)");
            str = tmp[0];
        } catch (Exception e) {
            iRecord.log("" + e.getStackTrace());
            e.printStackTrace();
        }
        return str;
    }
    
}
