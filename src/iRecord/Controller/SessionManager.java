/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package iRecord.Controller;

import entities.Musician;
import entities.Room;
import entities.Session;
import entities.Soundman;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class SessionManager {
    
    /**
     * Import studios to controller
     * @return
     */
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
     * Getting all musicians of the studio
     */
    public static void getMSMap(Map<Musician, Room> musicianMap, Studio stud, Date dateStart, Date dateEnd){
        //System.err.println("Getting MSMap for studio "+stud);
        
        
        //Get all musicians who are linked with this studio
        ResultSet qry = iRecord.getDB().query("SELECT Freelancer.FreelancerID, Freelancer.firstName, Freelancer.lastName, Freelancer.stageName, Musician.Payroll, Musician.expertIn, FreelancerToStudio.StudioID, FreelancerToStudio.Grade\n" +
                "FROM (Freelancer INNER JOIN FreelancerToStudio ON (Freelancer.FreelancerID = FreelancerToStudio.FreelancerID) AND (Freelancer.FreelancerID = FreelancerToStudio.FreelancerID)) INNER JOIN Musician ON (Freelancer.FreelancerID = Musician.MusicianID) AND (Freelancer.FreelancerID = Musician.MusicianID)\n" +
                "WHERE (((FreelancerToStudio.StudioID)="+stud.getsID()+"))\n" +
                        "ORDER BY FreelancerToStudio.Grade DESC;");
        try {
            while(qry.next()){
                System.err.println("Inserting Musician "+qry.getString("stageName")+" with priority "+qry.getString("Grade"));
                musicianMap.put(new Musician(qry.getString("FreelancerID"), qry.getString("firstName"), qry.getString("lastName"), qry.getString("stageName"), qry.getDouble("Payroll"), qry.getInt("expertIn"), qry.getInt("Grade")), null);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        java.sql.Date startDate = new java.sql.Date(dateStart.getTime());
        
        
        //Check availability
        qry = iRecord.getDB().query("SELECT Freelancer.FreelancerID, Freelancer.firstName, Freelancer.lastName, Freelancer.stageName, Musician.Payroll, Musician.expertIn, Session.sessionStartDate, Session.sessionEndDate, DateDiff(\"d\",[Session].[sessionStartDate],#1/10/2017#) AS Expr1, FreelancerToStudio.StudioID\n" +
                "FROM (Freelancer INNER JOIN ([Session] INNER JOIN (Musician INNER JOIN MusicianToRoom ON Musician.MusicianID = MusicianToRoom.MusicianID) ON Session.SessionID = MusicianToRoom.SessionID) ON Freelancer.FreelancerID = Musician.MusicianID) INNER JOIN FreelancerToStudio ON (FreelancerToStudio.FreelancerID = Freelancer.FreelancerID) AND (Freelancer.FreelancerID = FreelancerToStudio.FreelancerID)\n" +
                "WHERE (((DateDiff(\"d\",[Session].[sessionStartDate],#"+startDate+"#))=-1) AND ((FreelancerToStudio.StudioID)="+stud.getsID()+"));");
        //System.err.println("----Before Musician Map-----");
        for(Musician m : musicianMap.keySet()){
            System.err.println(m);
        }
        
        //Remove unavailable soundman from list
        try {
            while(qry.next()){
                System.err.println("Found working musician at the given date: "+qry.getString(1));
                //Check dates
                java.util.Date smStartDate = (java.util.Date) qry.getObject("sessionStartDate");
                java.util.Date smEndDate = (java.util.Date) qry.getObject("sessionEndDate");
                System.err.println("Musician "+qry.getString(1)+" Start: "+smStartDate+" End: "+smEndDate);
                if((smStartDate.before(dateStart) && smEndDate.after(dateStart))
                        || (smStartDate.after(dateStart) && smStartDate.before(dateEnd))
                        || (smEndDate.after(dateStart) && smEndDate.before(dateEnd))){
                    //Soundman isn't available
                    System.err.println("Musician "+qry.getString(1)+" isn't available");
                    musicianMap.remove(new Musician(qry.getString(1)));
                }
                musicianMap.remove(new Musician(qry.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Pring list of soundmans
        //System.err.println("----Musician Map-----");
        for(Musician m : musicianMap.keySet()){
            System.err.println(m);
        }
    }
    
    /**
     * Getting available Soundmen per studio and dates chosen
     * @param soundmenMap
     * @param stud
     * @param dateStart
     * @param dateEnd
     */
    public static void getSMMap(List<Soundman> soundmenMap, Studio stud, Date dateStart, Date dateEnd){
        
        System.err.println("Getting SMMap for studio "+stud);
        
        //Get all soundman for the chosen studio
        ResultSet qry = iRecord.getDB().query("SELECT Freelancer.FreelancerID, Freelancer.firstName, Freelancer.lastName, Freelancer.stageName, Soundman.isProducer, Soundman.isMixTech, Soundman.isMasterTech, Soundman.downPayment, Soundman.FullPayment, FreelancerToStudio.Grade\n" +
                "FROM (Freelancer INNER JOIN Soundman ON Freelancer.FreelancerID = Soundman.SoundmanID) INNER JOIN FreelancerToStudio ON (FreelancerToStudio.FreelancerID = Freelancer.FreelancerID) AND (Freelancer.FreelancerID = FreelancerToStudio.FreelancerID)\n" +
                "WHERE (((FreelancerToStudio.StudioID)="+stud.getsID()+")) order by Grade desc;");
        try {
            while(qry.next()){
                Soundman s = new Soundman(qry.getString(1), qry.getString(2), qry.getString(3), qry.getString(4), qry.getBoolean(5), qry.getBoolean(6), qry.getBoolean(7), qry.getDouble(8), qry.getDouble(9), qry.getInt(10));
                System.err.println("Added Soundman "+s.getFreelancerID()+" to SMMap");
                soundmenMap.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmCreateSession.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Soundman tmp : soundmenMap){
            System.err.println(tmp);
        }
        
        java.sql.Date startDate = new java.sql.Date(dateStart.getTime());
        ResultSet qry2 = iRecord.getDB().query("SELECT Soundman.SoundmanID, Session.sessionStartDate AS dateStart, Session.sessionEndDate AS dateEnd \n" +
                "FROM [Session] INNER JOIN (Soundman INNER JOIN SoundmanToSession ON Soundman.SoundmanID = SoundmanToSession.SoundmanID) ON Session.SessionID = SoundmanToSession.SessionID\n" +
                "WHERE (((SoundmanToSession.SessionID)=[Session].[SessionID]) AND DateDiff(\"d\",[Session].[sessionStartDate],#"+startDate+"#)=-1)");
        try {
            System.err.println("Session Start Date: "+dateStart+" EndDate: "+dateEnd);
            while(qry2.next()){
                //Check if dates are overlapping
                java.util.Date smStartDate = (java.util.Date) qry2.getObject("dateStart");
                java.util.Date smEndDate = (java.util.Date) qry2.getObject("dateEnd");
                System.err.println("Soundman "+qry2.getString(1)+" Start: "+smStartDate+" End: "+smEndDate);
                if((smStartDate.before(dateStart) && smEndDate.after(dateStart))
                        || (smStartDate.after(dateStart) && smStartDate.before(dateEnd))
                        || (smEndDate.after(dateStart) && smEndDate.before(dateEnd))){
                    //Soundman isn't available
                    System.err.println("Soundman "+qry2.getString(1)+" isn't available");
                    soundmenMap.remove(new Soundman(qry2.getString(1)));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method will remove rooms which are occupied between the given times on a studio
     * @param studioMap
     * @param dateStart
     * @param dateEnd
     */
    public static void clearRooms(Map<Integer, Studio> studioMap, Date dateStart, Date dateEnd){
        
        java.sql.Date startDate = new java.sql.Date(dateStart.getTime());
        //System.err.println("SQL Start Date: "+startDate+" Day: "+startDate.getDay());
        
        //Get sessions which dates are between the given dates
        ResultSet roomDates = iRecord.getDB().query("SELECT DateDiff(\"d\",[Session].[sessionStartDate],#"+startDate+"#), SessionInRoom.RoomNum, SessionInRoom.StudioID, SessionInRoom.SessionID, Session.sessionStartDate, Session.sessionEndDate\n" +
                "FROM [Session] INNER JOIN SessionInRoom ON Session.SessionID = SessionInRoom.SessionID\n" +
                "WHERE (((SessionInRoom.SessionID)=[Session].[SessionID]) AND ((DateDiff(\"d\",[Session].[sessionStartDate],#"+startDate+"#))=-1))");
        //System.err.println("Start date: "+dateStart + "End date: "+dateEnd);
        //System.err.println("Testing Data:::::");
        //System.err.println("Before");
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
    
    /**
     * Adds a given session to DB
     * @param ses
     */
    public static void addSession(Session ses){
        System.err.println("Adding session #"+ses.getSessionID());
        java.sql.Timestamp sDate = new java.sql.Timestamp(ses.getSessionStartDate().getTime());
        java.sql.Timestamp eDate = new java.sql.Timestamp(ses.getSessionEndDate().getTime());
        
        //Add new session record to Session tbl
        ses.setSessionID(iRecord.getDB().updateReturnID("INSERT INTO Session (ArtistID, sessionStartDate, sessionEndDate, totalCost) VALUES (\""+ses.getArt().getID()+"\", \""+sDate+"\", \""+eDate+"\","+ses.getCost()+")"));
        
        //Add rooms to the session
        for(Room r : ses.getRoomList()){
            iRecord.getDB().updateReturnID("INSERT INTO SessionInRoom VALUES ("+ses.getSessionID()+", "+r.getRoomNum()+", "+ses.getStud().getsID()+")");
        }
        //Add soundmen to session
        for(Soundman s : ses.getChosenSoundmen()){
            if(s.getIsMasterTech())
                iRecord.getDB().updateReturnID("INSERT INTO SoundmanToSession VALUES ("+ses.getSessionID()+", \""+s.getFreelancerID()+"\", \"MasterTech\")");
            if(s.getIsMixTech())
                iRecord.getDB().updateReturnID("INSERT INTO SoundmanToSession VALUES ("+ses.getSessionID()+", \""+s.getFreelancerID()+"\", \"MixTech\")");
            if(s.getIsProducer())
                iRecord.getDB().updateReturnID("INSERT INTO SoundmanToSession VALUES ("+ses.getSessionID()+", \""+s.getFreelancerID()+"\", \"Producer\")");
        }
        
        //Add Musician to rooms
        for(Map.Entry<Musician, Room> e : ses.getChosenMusicians().entrySet())
            iRecord.getDB().updateReturnID("INSERT INTO MusicianToRoom VALUES (\""+e.getKey().getFreelancerID()+"\", "+ses.getSessionID()+", "+e.getValue().getRoomNum()+", "+ses.getStud().getsID()+")");
        
        
        
        
    }
    
}
