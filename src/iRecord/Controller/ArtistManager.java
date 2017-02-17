package iRecord.Controller;

import entities.*;
import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public static boolean checkExistence(String ArtistID){
        boolean flag = false;
        //chech if artist is already exists
        ResultSet rs = iRecord.getDB().query("SELECT Artists.* FROM Artists WHERE [Artists].[ArtistID]=" + ArtistID);
        
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
    public static void addArtist(Artist artist){
        iRecord.getDB().updateReturnID("INSERT INTO Artists VALUES ("+artist.getID() + artist.getStageName() + artist.getEmailAddr() + artist.getPassword() + artist.getDateExpired()+")");
        return;
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
    
    
    
}
