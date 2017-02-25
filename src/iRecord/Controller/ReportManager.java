package iRecord.Controller;

import iRecord.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micke
 */
public class ReportManager {
    //jdbc:ucanaccess://C:/Users/micke/Documents/NetBeansProjects/iRECORD/iRecord/src/sources/iRecord.accdb
    
    
    public static ArrayList<String> getSoundmansOfSession(int sessionID){
        ArrayList<String> toReturn = null;
        String qry = "SELECT SessionInRoom.SessionID, SessionInRoom.RoomNum, SessionInRoom.StudioID, MusicianToRoom.MusicianID, MusicianToRoom.SessionID, Freelancer.stageName \n" +
                "FROM Freelancer INNER JOIN (Room INNER JOIN (SessionInRoom INNER JOIN MusicianToRoom ON SessionInRoom.[StudioID] = MusicianToRoom.[StudioID]) ON (Room.StudioID = SessionInRoom.StudioID) AND (Room.RoomNum = SessionInRoom.RoomNum)) ON Freelancer.FreelancerID = MusicianToRoom.MusicianID \n" +
                "WHERE (((SessionInRoom.SessionID)=[MusicianToRoom].[SessionID]) AND ((SessionInRoom.RoomNum)=[Room].[RoomNum]) AND ((SessionInRoom.StudioID)=[Room].[RoomNum]) AND ((MusicianToRoom.SessionID)="+sessionID+"));";
        
        
        ResultSet rs = iRecord.getDB().query(qry);
        
        
        try {
            while(rs.next()){
                if (toReturn == null) toReturn = new ArrayList<String>();
                toReturn.add(rs.getString("stageName") + " ("+rs.getString("musicianID")+")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toReturn;
    }
    
    
    
    
    
    public static ArrayList<String> getMusiciansOfSession(int sessionID){
        ArrayList<String> toReturn = null;
        
        String qry = "SELECT SoundmanToSession.SessionID, SoundmanToSession.SoundmanID, Freelancer.FreelancerID, Freelancer.stageName\n" +
                "FROM Freelancer INNER JOIN ([Session] INNER JOIN SoundmanToSession ON Session.[SessionID] = SoundmanToSession.[SessionID]) ON Freelancer.FreelancerID = SoundmanToSession.SoundmanID\n" +
                "GROUP BY SoundmanToSession.SessionID, SoundmanToSession.SoundmanID, Freelancer.FreelancerID, Freelancer.stageName\n" +
                "HAVING (((SoundmanToSession.SessionID)="+sessionID+"));";
        
        
        ResultSet rs = iRecord.getDB().query(qry);
        
        
        try {
            while(rs.next()){
                if (toReturn == null) toReturn = new ArrayList<String>();
                toReturn.add(rs.getString("stageName") + " ("+rs.getString("soundmanID")+")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return toReturn;
    }
    
    
    
    
    
    public static String[] getSongDetails(int sessionID) {
        String[] toReturn = null;
        String qry = "SELECT Recording.* FROM Recording WHERE Recording.SessionID=\""+sessionID+"\"";
       
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            if (rs.next()){
                //System.out.println("iRecord.Controller.ReportManager.getSongDetails()");
                toReturn = new String[2];
                toReturn[0] = rs.getString("title");
                toReturn[1] = rs.getString("sonGURL");
                ///System.out.println(toReturn[0] + toReturn[1]);
                return toReturn;
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(RecordingManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return toReturn;
    }
    
    
    
}
