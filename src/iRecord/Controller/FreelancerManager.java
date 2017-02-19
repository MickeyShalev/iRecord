package iRecord.Controller;

import entities.Freelancer;
import entities.Soundman;
import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mickey
 */
public class FreelancerManager {
    
    public static int addSoundman(Soundman s){
        int status = -1;
        
        java.sql.Timestamp eDate = new java.sql.Timestamp (a.getDateExpired().getTime());
        
        //insert soundman to freelancer table - query
        String qry = "INSERT INTO Freelancer (ArtistID, StageName, sEmail, strPasswd, dateExpired)"
                + " VALUES (\"" +a.getID() +"\", \""+a.getStageName()+"\" ,\""+a.getEmailAddr()+"\", \""+a.getPassword()+"\",\"" + eDate + "\")";
        
        //insert soundman to soundman table - query
        String qry = "INSERT INTO Soundman (ArtistID, StageName, sEmail, strPasswd, dateExpired)"
                + " VALUES (\"" +a.getID() +"\", \""+a.getStageName()+"\" ,\""+a.getEmailAddr()+"\", \""+a.getPassword()+"\",\"" + eDate + "\")";
        
        
        if (iRecord.getDB().updateReturnID(qry) < 0) {                                      //
            status = -1;
        }
         
        return status;
    }
    
    
    /**
     * 
     */
    public static void addMusician(){
        
        
    }
    
    
    /**
     * this method connects a freelancer to studio and adds rating to the freelancer
     * might need remove method as well
     */
    public static void rateFreelancer(){
        
        
    }
    
    
    
    /**
     * This method confirms if a freelancer is already exists
     * @param ID
     * @return ture if exist
     */
    public static boolean isExists(String ID){
        //chech if artist is already exists
        ResultSet rs = iRecord.getDB().query("SELECT Freelancer.*, Freelancer.FreelancerID\n" +
                "FROM Freelancer\n" +
                "WHERE (((Freelancer.FreelancerID)=\""+ID+"\"))");
        
        //if exists return ture
        try {
            if (rs.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
