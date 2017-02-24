package iRecord.Controller;

import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jrockit.jfr.Recording;
import org.joda.time.format.DateTimeFormat;

/**
 * Class manages the recordings
 * @author mickey
 */



public class RecordingManager {
    
    /**
     * This method gets all required recordings of artist starting from date
     * @param id
     * @return 
     */
    public static ArrayList<String[]> getArtistSessions(String id, Timestamp t){
        ArrayList<String[]> toReturn = new ArrayList<String[]>();
        
        String qry = "SELECT Artists.ArtistID AS Artists_ArtistID, Studio.StudioID, Studio.sName, Count(Session.SessionID) AS CountOfSessionID, Session.ArtistID AS Session_ArtistID, Session.sessionStartDate, Session.TotalCost, Session.SessionID\n" +
                     "FROM (Studio INNER JOIN Room ON Studio.[StudioID] = Room.[StudioID]) INNER JOIN ((Artists INNER JOIN [Session] ON Artists.[ArtistID] = Session.[ArtistID]) INNER JOIN SessionInRoom ON Session.[SessionID] = SessionInRoom.[SessionID]) ON (Room.[StudioID] = SessionInRoom.[StudioID]) AND (Room.[RoomNum] = SessionInRoom.[RoomNum])\n" +
                     "GROUP BY Artists.ArtistID, Studio.StudioID, Studio.sName, Session.ArtistID, Session.sessionStartDate, Session.TotalCost, Session.SessionID\n" +
                     "HAVING (((Session.ArtistID)=\""+id+"\") AND ((Session.sessionStartDate)>\""+t+"\")) "+
                     "ORDER BY Session.sessionStartDate;";
        
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            while(rs.next()){
                String Studioid = rs.getString("studioid");
                String studioName = rs.getString("sName");
                String SessionId = rs.getString("sessionID");
                String cost = rs.getString("totalCost");
                Date date =  new Date(rs.getTimestamp("sessionStartDate").getTime());
                SimpleDateFormat dft = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                dft.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
                toReturn.add(new String[]{Studioid ,studioName, SessionId, dft.format(date).toString(), cost});
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecordingManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return toReturn;
    }
    
    /**
     * This method adds a recording to the DB
     * @param sesssionID
     * @param r
     * @return 
     */
    public static int addRecording(int sesssionID, Recording r){
        int status = -1;
        
        
        return status;
    }
    
    /**
     * This method checks if a recording was added to DB
     * @param r
     * @return 
     */
    public static boolean isExists(String id){
        
        
        return false;
    }

    public static boolean isArtistsRec(String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String getRecordingStatus(String temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
