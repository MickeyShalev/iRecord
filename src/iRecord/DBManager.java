/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iRecord;

import java.sql.*;
import iRecord.iRecord;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DB Connection Manager
 * @author Administrator
 */
public class DBManager {
    private static Connection conn;
    
   
    public DBManager() throws ClassNotFoundException, SQLException{
        String dbFile = (new File("sources/iRecord.accdb")).getAbsolutePath();
        iRecord.log("DB File: "+dbFile);
        String driver="net.ucanaccess.jdbc.UcanaccessDriver"; 
        Class.forName(driver); 
        try{
        conn=DriverManager.getConnection("jdbc:ucanaccess://"+dbFile);    
        System.err.println("Connecting with: jdbc:ucanaccess://"+dbFile);
        }
        catch(Exception e){
            dbFile = (new File("src/sources/iRecord.accdb")).getAbsolutePath();
            System.err.println("Connecting with: jdbc:ucanaccess://"+dbFile);
            conn=DriverManager.getConnection("jdbc:ucanaccess://"+dbFile);
        }
        
    }
    
    /**
     * This method returns a ResultSet on given SQL Query
     * @param SQL
     * @return 
     */
    public static ResultSet query(String SQL){
        ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /**
     * This is an update query which returns the generated keys
     * TO TEST
     * @param SQL
     * @return
     * @throws SQLException 
     */
    public int updateReturnID(String SQL){
        int id=-1;
        iRecord.log("Sending UPDATE Query: "+SQL);
        try {
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = stmt.getGeneratedKeys();
            if(result.next()){
                id=result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    /**
     * This method will check if a row exists on given SQL Query
     * @param SQL
     * @return true if exists, false otherwise
     */
    public static Boolean queryBool(String SQL){
        ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(SQL);
            if(result.next())
                if(result.getInt(1)>0)
                    return true;
 
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return false;
    }
    
    /**
     * 
     * @param SQL
     * @return 
     */
    public static ResultSet executeUpadate(String SQL){
        ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        DBManager.conn = conn;
    }
    
    
}


