package iRecord.Controller;

import entities.*;
import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mickey
 */
public class ArtistManager {
    
    /**
     * This method gets ID and checks if this ID already exists in the DB
     * @param ArtistID
     * @return true if exists
     */
    public static boolean isExists(String ArtistID){
        boolean flag = false;
        
        //chech if artist is already exists
        ResultSet rs = iRecord.getDB().query("SELECT Artists.*, Artists.ArtistID\n" +
                "FROM Artists\n" +
                "WHERE (((Artists.ArtistID)=\""+ArtistID+"\"))");
        
        //Map<String, Artist> toReturn = new HashMap<String, Artist>();
        
        //if exists return ture
        try {
            if (rs.next()){
                flag = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
    
    
    /**
     * This method adds the artist to the DB
     * @param Artist
     */
    public static int addArtist(Artist a){
        
        int status = 1;
           
        java.sql.Timestamp eDate = new java.sql.Timestamp (a.getDateExpired().getTime());
        String qry = "INSERT INTO artists (ArtistID, StageName, sEmail, strPasswd, dateExpired)"
                + " VALUES (\"" +a.getID() +"\", \""+a.getStageName()+"\" ,\""+a.getEmailAddr()+"\", \""+a.getPassword()+"\",\"" + eDate + "\")";
        
        
        if (iRecord.getDB().updateReturnID(qry) < 0) {                                      //
            status = -1;
        }
        
        return status;
    }
    
    
    /**
     * This method suspends artist from the system
     * @param ArtistID
     */
    public static void suspendArtist(String ArtistID){
        
        
    }
    
    
    /**
     * This method cancels suspension of artist from the system
     * @param ArtistID
     */
    public static void unSuspendArtist(String ArtistID){
        
        
        
    }
    
    
    /**
     * TEMP QUERY FOR TESTING
     * @return 
     */
    public static int addA(){
        
        int status = 1;
        java.sql.Timestamp eDate = new java.sql.Timestamp (new java.util.Date().getTime());
        String qry = "INSERT INTO artists (ArtistID, StageName, sEmail, strPasswd, dateExpired)"
                + " VALUES (\"AR999\", \"TIM\" ,\"tim@tim.com\", \"1234\",\"" + eDate + "\")";
        
        
        if (iRecord.getDB().updateReturnID(qry) < 0) {                                      //
            status = -1;
        }
        
        return status;
    }
    
    
    
}
