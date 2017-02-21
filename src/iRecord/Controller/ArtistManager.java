package iRecord.Controller;

import entities.*;
import iRecord.DBManager;
import iRecord.iRecord;
import iRecord.utilities.EAuth;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
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
        
        int status = -1;
           
        java.sql.Timestamp eDate = new java.sql.Timestamp (a.getDateExpired().getTime());
        String qry = "INSERT INTO artists (ArtistID, StageName, sEmail, strPasswd, dateExpired)"
                + " VALUES (\"" +a.getID() +"\", \""+a.getStageName()+"\" ,\""+a.getEmailAddr()+"\", \""+a.getPassword()+"\",\"" + eDate + "\")";
        
        
        iRecord.getDB().updateReturnID(qry);
        if (isExists(a.getID()))
            status = 1;
        
        
        return status;
    }
    
    
    /**
     * This method suspends / unsuspends artist from the system using update query
     * @param ArtistID
     * @param EndOfSuspensionDate
     */
    public static void updateStatus(String id, Timestamp date){
        
        iRecord.getDB().executeUpadate("UPDATE Artists SET dateExpired=\""+date+"\" WHERE Artists.ArtistID=\""+id+"\"" );
        
        return;
        
    }

    
    /**
     * this method gets artist id and returns the artist details
     * @return 
     */
    public static Artist getArtist(String id){
        Artist a = null;
        
        ResultSet rs = iRecord.getDB().query("SELECT Artists.*, Artists.ArtistID\n" +
                "FROM Artists\n" +
                "WHERE (((Artists.ArtistID)=\""+id+"\"))");
        
        try {
            if (rs.next()){
                String artistID = rs.getString("Artistid");
                String stageName = rs.getString("stageName");
                java.sql.Timestamp eDate = rs.getTimestamp("dateExpired");
                java.sql.Date date = new java.sql.Date (eDate.getTime());
                a = new Artist (artistID, stageName, " ", " ", date, EAuth.Artist);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArtistManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return a;
    } 
    
}
