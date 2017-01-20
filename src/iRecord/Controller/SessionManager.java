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
import java.util.Iterator;
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
        System.err.println("Start date: "+dateStart
                + "End date: "+dateEnd);
      System.err.println("Testing Data:::::");
      System.err.println("Before");
                for(Studio s : studioMap.values()){
                    System.err.println("Studio#"+s.getsID());
                    for(Room r : s.getsRooms().values())
                        System.err.println("\tRoom#"+r.getRoomNum());
                    
                }
        try {
            while(roomDates.next()){
                
                Integer RoomNum = roomDates.getInt(2);
                System.err.println("-----"+RoomNum+"-----");
                java.util.Date sessionStart = (java.util.Date) roomDates.getObject("sessionStartDate");
                java.util.Date sessionEnd = (java.util.Date) roomDates.getObject("sessionEndDate");
                
                
                if(
                        (sessionStart.before(dateStart) && sessionEnd.after(dateEnd))
                        ||
                        (sessionStart.after(dateStart) && sessionStart.before(dateEnd))
                        ||
                        (sessionEnd.after(dateStart) && sessionEnd.before(dateEnd))){
                   // System.err.println("FOUND ROOM #"+RoomNum);
                    System.err.println("deleting room #"+RoomNum+" from studio"+roomDates.getInt("StudioID"));
                    //Delete the room from the general hashmap
                    studioMap.get(roomDates.getInt("StudioID")).getsRooms().remove(RoomNum);
                    
                }
                
               
                
                
                
            }
             System.err.println("After");
                for(Studio s : studioMap.values()){
                    System.err.println("Studio#"+s.getsID());
                    for(Room r : s.getsRooms().values())
                        System.err.println("\tRoom#"+r.getRoomNum());
                    
                }
                  
            
            //Get their rooms
            //Remove the rooms from the map
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Iterator<Studio> it = studioMap.values().iterator();
        
        while(it.hasNext()){
            Studio s =  it.next();
            if(s.getsRooms().size()==0){
                it.remove();
                continue;
            }
            
            Boolean flag = false;
            Iterator<Room> it2 = s.getsRooms().values().iterator();
            while(it2.hasNext()){
                Room r = it2.next();
                if(r.getHasIsolation())
                    flag=true;
            }
            for(Room r : s.getsRooms().values())
                if(r.getHasIsolation())
                    flag=true;
                
            
            
            if(!flag)
                it.remove();
            
        }
        System.err.println("Studio Cleanup:");
                for(Studio s : studioMap.values()){
                    System.err.println("Studio#"+s.getsID());
                    for(Room r : s.getsRooms().values())
                        System.err.println("\tRoom#"+r.getRoomNum());
                    
                }
                  
        
        
    }
    
}
