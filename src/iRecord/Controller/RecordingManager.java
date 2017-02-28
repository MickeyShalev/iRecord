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
import entities.*;

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
        //get sessions details
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
                String[] temp = getSessionStatus(SessionId);
                if (temp == null) toReturn.add(new String[]{Studioid ,studioName, SessionId, dft.format(date).toString(), cost, "N/A", "N/A"});
                else  toReturn.add(new String[]{Studioid ,studioName, SessionId, dft.format(date).toString(), cost, temp[0], temp[1]});
                
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
    public static int addRecording(Recording r){
        int status = -1;
        String qry = "INSERT INTO Recording (RecordID, SessionID, Title, songURL, songLength, Lyrics, RecordingLink, iStatus, priorRecording) "+
                     " VALUES(\""+r.getRecID()+"\", "+r.getsessionID()+", \""+r.getName()+"\", \""+r.getUrl()+"\", "+r.getLength()+", \""+r.getLyrics()+"\", \""+r.getFilePath()+"\", \"" +r.getStatus()+"\", \""+r.getPrevRec()+"\" )";
        
        iRecord.getDB().executeUpadate(qry);
        
        if (getRecordingStatus(r.getRecID()) !=null){
            status = 1;
        }
 
        return status;
    }

    
    /**
     * This method checks if a recording belongs to artist or not
     * @param id
     * @param artist
     * @return 
     */
    public static boolean isArtistsRec(String id, String artist) {
        boolean status = false;
        
        String qry = "SELECT Recording.RecordID, Recording.SessionID AS Recording_SessionID, Session.SessionID AS Session_SessionID, Session.ArtistID, Recording.iStatus\n" +
                     "FROM [Session] INNER JOIN Recording ON Session.[SessionID] = Recording.[SessionID]\n" +
                     "WHERE (((Recording.RecordID)=\""+id+"\") AND ((Recording.SessionID)=[Session].[SessionID]));";
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            if (rs.next()){
                if (rs.getString("ArtistID").equals(artist)){
                    status = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecordingManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    /**
     * This method get recording status
     * @param id
     * @return 
     */
    public static String getRecordingStatus(String recID) {
        String toReturn = null;
        String qry = "SELECT Recording.* FROM Recording WHERE Recording.Recordid=\""+recID+"\"";
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            if (rs.next()){
                toReturn = rs.getString("iStatus");
            }
         
                return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(RecordingManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toReturn;
    }
    
    
    public static String[] getSessionStatus(String sessionID) {
        String[] toReturn = null;
        String qry = "SELECT Recording.* FROM Recording WHERE Recording.SessionID=\""+sessionID+"\"";
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            if (rs.next()){
                if (toReturn == null) toReturn = new String[2]; 
                toReturn[0] = rs.getString("iStatus");
                toReturn[1] = rs.getString("RecordID");
            }
         
                return toReturn;
        } catch (SQLException ex) {
            Logger.getLogger(RecordingManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toReturn;
    }
    
    
    
    public static boolean isAlreadyPrevious(String recID) {
        String qry = "SELECT Recording.* FROM Recording WHERE Recording.priorRecording=\""+recID+"\"";
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            if (rs.next()){
                return false;
            }
         
               
        } catch (SQLException ex) {
            Logger.getLogger(RecordingManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
 
}
