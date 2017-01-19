/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iRecord.Controller;

import entities.Room;
import entities.Studio;
import gui.internal.frmCreateSession;
import java.util.Map;
import iRecord.iRecord;
import iRecord.DBManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class SessionManager {
    
    public static Map<Integer, Studio> getStudios(){
        Map<Integer, Studio> toReturn = new HashMap<Integer, Studio>();
        
        ResultSet rs = iRecord.getDB().query("select * from Studio");
        try {
            while(rs.next()){
                //Studio Details
                Integer StudioID = rs.getInt("StudioID");
                String sName = rs.getString("sName");
                String sAddress = rs.getString("sAddress");
                String sEmail = rs.getString("sEmail");
                String sPhoneNum = rs.getString("sPhoneNum");
                String sDesc = rs.getString("sDesc");
                Studio stud = new Studio(sName, sAddress, sEmail, sPhoneNum, sDesc, StudioID);
                toReturn.put(StudioID, stud);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return toReturn;
        
    }
    
    
    /**
     * This method will remove rooms which are occupied between the given times on a studio
     * @param studioMap
     * @param dateStart
     * @param dateEnd 
     */
    public static void clearRooms(Map<Integer, Studio> studioMap, Date dateStart, Date dateEnd){
        java.sql.Date startDate = new java.sql.Date(dateStart.getTime());
        System.err.println("SQL Start Date: "+startDate+" Day: "+startDate.getDay());
        //Get sessions which dates are between the given dates
        ResultSet roomDates = iRecord.getDB().query("SELECT DateDiff(\"d\",[Session].[sessionStartDate],#"+startDate+"#), SessionInRoom.RoomNum, SessionInRoom.StudioID, SessionInRoom.SessionID, Session.sessionStartDate, Session.sessionEndDate\n" +
"FROM [Session] INNER JOIN SessionInRoom ON Session.SessionID = SessionInRoom.SessionID\n" +
"WHERE (((SessionInRoom.SessionID)=[Session].[SessionID]) AND ((DateDiff(\"d\",[Session].[sessionStartDate],#"+startDate+"#))=-1))");
        
      System.err.println("Testing Dates:::::");
        try {
            while(roomDates.next()){
                
                Integer RoomNum = roomDates.getInt(2);
                System.err.println("-----"+RoomNum+"-----");
                java.util.Date sessionStart = (java.util.Date) roomDates.getObject("sessionStartDate");
                java.util.Date sessionEnd = (java.util.Date) roomDates.getObject("sessionEndDate");
                
                System.err.println("Given start date: "+dateStart+"\nGiven End Date: "+dateEnd);
                System.err.println("Room start date: "+sessionStart+"\nRoom End Date: "+sessionEnd);
                
                if(
                        (sessionStart.before(dateStart) && sessionEnd.after(dateEnd))
                        ||
                        (sessionStart.after(dateStart) && sessionStart.before(dateEnd))
                        ||
                        (sessionEnd.after(dateStart) && sessionEnd.before(dateEnd))){
                    System.err.println("FOUND ROOM #"+RoomNum);
                    
                    //Delete the room from the general hashmap
                    if(studioMap.get(roomDates.getInt("StudioID")).getsRooms().remove(new Room(RoomNum)))
                        System.err.println("Deleted Room #"+RoomNum);
                    
                }
                
                
                
                
            }
                  
            
            //Get their rooms
            //Remove the rooms from the map
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for(Studio s : studioMap.values()){
            if(s.getsRooms().size()==0)
                studioMap.remove(s);
            
            Boolean flag = false;
            
            for(Room r : s.getsRooms())
                if(r.getHasIsolation())
                    flag=true;
                
            
            
            if(!flag)
                studioMap.remove(s);
            
        }
        
        
    }
    
}
