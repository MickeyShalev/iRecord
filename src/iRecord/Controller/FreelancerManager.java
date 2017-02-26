package iRecord.Controller;

import entities.Freelancer;
import entities.Musician;
import entities.Soundman;
import entities.Studio;
import static iRecord.Controller.RecordingManager.getSessionStatus;
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

/**
 *
 * @author mickey
 */
public class FreelancerManager {
    
    public static int addSoundman(Soundman s){
        int status = -1;
        
        java.sql.Timestamp eDate = new java.sql.Timestamp (s.getBirthdate().getTime());
        
        //insert soundman to freelancer table - query
        String qry1 = "INSERT INTO Freelancer (FreelancerID, firstName, lastName, stageName, birthDate, strEmail, Password, Status ,filePic)"
                + " VALUES (\"" +s.getFreelancerID() +"\", \""+s.getFirstName()+"\" ,\""+s.getLastName()+"\", \""+s.getStageName()+"\", \"" +eDate+ "\", \""+s.getEmail() +"\", \""+s.getPassword()+"\","+s.getStatus()+ ", \""+s.getPicPath()+"\" )";
        
        //insert soundman to soundman table - query
        int producer = s.getIsProducer()? 1 : 0;
        int mix = s.getIsMixTech()? 1 : 0;
        int master = s.getIsMasterTech()? 1 : 0;
        String qry2 = "INSERT INTO Soundman (SoundmanID, isProducer, isMixTech, isMasterTech, downPayment, FullPayment)"
                + " VALUES (\"" + s.getFreelancerID() +"\", "+producer+" ," +mix+ ", " +master+ "," +s.getDownPayment()+ ", " +s.getFullPayment()+")";
        
        
        iRecord.getDB().updateReturnID(qry1);
        iRecord.getDB().updateReturnID(qry2);
        
        if (isExists(s.getFreelancerID()))
            status = 1;
        
        
        
        return status;
    }
    
    
    /**
     *
     */
    public static int addMusician(Musician s){
        int status = -1;
        
        java.sql.Timestamp eDate = new java.sql.Timestamp (s.getBirthdate().getTime());
        
        String qry1 = "INSERT INTO Freelancer (FreelancerID, firstName, lastName, stageName, birthDate, strEmail, Password, Status ,filePic)"
                + " VALUES (\"" +s.getFreelancerID() +"\", \""+s.getFirstName()+"\" ,\""+s.getLastName()+"\", \""+s.getStageName()+"\", \"" +eDate+ "\", \""+s.getEmail() +"\", \""+s.getPassword()+"\","+s.getStatus()+ ", \""+s.getPicPath()+"\")";
        
        String qry2 = "INSERT INTO Musician (MusicianID, Payroll, expertIn)"
                + " VALUES (\"" + s.getFreelancerID() +"\", "+s.getPayRoll()+" , " +s.getExpertise().intValue()+")";
        
        iRecord.getDB().updateReturnID(qry1);
        iRecord.getDB().updateReturnID(qry2);
        
        if (isExists(s.getFreelancerID()))
            status = 1;
        
        return status;
    }
    
    
    /**
     * this method connects a freelancer to studio and adds rating to the freelancer
     * might need remove method as well
     */
    public static void connectFreelancer(Freelancer f, Studio s, int rating){
        
        String qry = "INSERT INTO FREELANCERTOSTUDIO (StudioID, FreelancerID, Grade) "
                + "VALUES ("+s.getsID()+", \""+f.getFreelancerID()+"\", "+ rating+")";
        
        iRecord.getDB().updateReturnID(qry);
        
    }
    
    /**
     * This method disconnects freelancer from a selected studio
     */
    public static void disconnectFreelancer(Freelancer f, Studio s){
        
        String qry = "DELETE FROM FreelancerToStudio \n"
                +"WHERE studioid = "+s.getsID()+" AND freelancerID = \""+ f.getFreelancerID()+"\"";
        
        iRecord.getDB().executeUpadate(qry);
        
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
    
    
    public static boolean isWorkingWithStudio(Freelancer f, Studio s){
        String qry = "SELECT FreelancerToStudio.StudioID, FreelancerToStudio.FreelancerID\n" +
                "FROM FreelancerToStudio "
                + "WHERE studioid = "+s.getsID()+" AND freelancerID = \""+ f.getFreelancerID()+"\"";
        
        ResultSet rs = iRecord.getDB().query(qry);
        
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
    
    
    public static Freelancer getFreelancer(String id){
        Freelancer f = null;
        
        ResultSet rs = iRecord.getDB().query("SELECT Freelancer.*, Freelancer.FreelancerID\n" +
                "FROM Freelancer\n" +
                "WHERE (((Freelancer.FreelancerID)=\""+id+"\"))");
        
        try {
            if (rs.next()){
                String flid = rs.getString("FreelancerID");
                String stageName = rs.getString("stageName");
                int status = rs.getInt("status");
                f = new Freelancer(flid);
                f.setStageName(stageName);
                f.setStatus(status);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArtistManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return f;
    }
    
    
    
    /**
     * Helper method to add freelancers list to jtable
     * @return
     */
    public static ArrayList<String[]> getArtistList(String sortType){
        ArrayList<String[]> toReturn = new ArrayList<String[]>();
        
        String qry1 = "SELECT Freelancer.FreelancerID, Musician.MusicianID, Musician.Payroll, Musician.expertIn, Freelancer.firstName, Freelancer.lastName, Freelancer.stageName, Freelancer.birthDate, Freelancer.strEmail, Freelancer.Status FROM Freelancer INNER JOIN Musician ON Freelancer.[FreelancerID] = Musician.[MusicianID] WHERE (((Freelancer.FreelancerID)=[MusicianID])) ORDER BY  " +sortType;
        String qry2 = "SELECT Freelancer.FreelancerID, Freelancer.firstName, Freelancer.lastName, Freelancer.stageName, Freelancer.birthDate, Freelancer.strEmail, Freelancer.Status, Soundman.SoundmanID, Soundman.isProducer, Soundman.isMixTech, Soundman.isMasterTech, Soundman.downPayment, Soundman.FullPayment FROM Freelancer, Soundman WHERE (((Freelancer.FreelancerID)=[Soundman].[SoundmanID])) ORDER BY " + sortType;
        
        ResultSet rs1 = iRecord.getDB().query(qry1);
        ResultSet rs2 = iRecord.getDB().query(qry2);
        
        try {
            while(rs1.next()){
                String id = rs1.getString("FreelancerID");
                String stageName = rs1.getString("stageName");
                String email = rs1.getString("strEmail");
                String status = rs1.getInt("Status")==1? "Actice":"inActive";
                toReturn.add(new String[]{id, stageName, email, status +" - Musician"});
            }
            
            while(rs2.next()){
                String id = rs2.getString("FreelancerID");
                String stageName = rs2.getString("stageName");
                String email = rs2.getString("strEmail");
                String status = rs2.getInt("Status")==1? "Actice":"inActive";
                toReturn.add(new String[]{id, stageName, email,status +" - Soundman"});
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ArtistManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toReturn;
    }
    
    /**
     * This method updates the status of freelancer
     * @param id
     * @param status
     */
    public static void updateStatus(String id, int status){
        
        iRecord.getDB().executeUpadate("UPDATE Freelancer SET Status="+status+" WHERE Freelancer.FreelancerID=\""+id+"\"" );
        
        return;
    }
    
    /**
     * This method returns the dates and places freelancer is scheduled for a session
     * @return
     */
    public static String[] getSessions(){
        String[] toReturn = null;
        
        String qry = " ";
        
        
        
        
        return toReturn;
    }
    
    public static ArrayList<String[]> getSoundmamSessions(String id, Timestamp t){
        ArrayList<String[]> toReturn = null;
        
        String qry = "SELECT SoundmanToSession.SessionID, SoundmanToSession.SoundmanID, Session.sessionStartDate, Studio.StudioID, Studio.sName, Artists.StageName, SoundmanToSession.Role, SoundmanToSession.Role\n" +
                "FROM Artists INNER JOIN (([Session] INNER JOIN ((Studio INNER JOIN Room ON Studio.[StudioID] = Room.[StudioID]) INNER JOIN SessionInRoom ON (Room.[StudioID] = SessionInRoom.[StudioID]) AND (Room.[RoomNum] = SessionInRoom.[RoomNum])) ON Session.[SessionID] = SessionInRoom.[SessionID]) INNER JOIN SoundmanToSession ON Session.[SessionID] = SoundmanToSession.[SessionID]) ON Artists.ArtistID = Session.ArtistID\n" +
                "GROUP BY SoundmanToSession.SessionID, SoundmanToSession.SoundmanID, Session.SessionID, Session.ArtistID, Session.sessionStartDate, Studio.StudioID, Studio.sName, Artists.StageName, SoundmanToSession.Role, SoundmanToSession.Role\n " +
                "HAVING (((SoundmanToSession.SoundmanID)=\""+id+"\") AND ((Session.sessionStartDate)>\""+t+"\"))\n" +
                "ORDER BY Session.sessionStartDate;";
        
        
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            while(rs.next()){
                if (toReturn == null) toReturn = new ArrayList<String[]>();
                String Studioid = rs.getString("studioid");
                String studioName = rs.getString("sName");
                String SessionId = rs.getString("sessionID");
                String artist = rs.getString("stageName");
                Date date =  new Date(rs.getTimestamp("sessionStartDate").getTime());
                SimpleDateFormat dft = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                dft.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
                String role = rs.getString("role");
                toReturn.add(new String[]{Studioid ,studioName, SessionId, dft.format(date).toString(), artist});
            }
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return toReturn;
    }
    
    
    public static ArrayList<String[]> getMusicianSessions(String id, Timestamp t){
        ArrayList<String[]> toReturn = null;
        
        String qry = "SELECT Musician.MusicianID, Session.SessionID, Session.sessionStartDate, Studio.StudioID, Studio.sName, Artists.StageName\n" +
                "FROM Studio INNER JOIN ((Artists INNER JOIN [Session] ON Artists.ArtistID = Session.ArtistID) INNER JOIN ((Room INNER JOIN SessionInRoom ON (Room.StudioID = SessionInRoom.StudioID) AND (Room.RoomNum = SessionInRoom.RoomNum)) INNER JOIN ((Freelancer INNER JOIN Musician ON Freelancer.FreelancerID = Musician.MusicianID) INNER JOIN MusicianToRoom ON Musician.MusicianID = MusicianToRoom.MusicianID) ON (SessionInRoom.StudioID = MusicianToRoom.StudioID) AND (SessionInRoom.RoomNum = MusicianToRoom.RoomNum) AND (SessionInRoom.SessionID = MusicianToRoom.SessionID)) ON Session.SessionID = SessionInRoom.SessionID) ON Studio.StudioID = Room.StudioID\n" +
                "GROUP BY Musician.MusicianID, Session.SessionID, Session.sessionStartDate, Studio.StudioID, Studio.sName, Artists.StageName\n" +
                "HAVING (((Musician.MusicianID)=\""+id+"\") AND ((Session.sessionStartDate)>\""+t+"\")) \n" +
                "ORDER BY Session.sessionStartDate;";
        
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            while(rs.next()){
                if (toReturn == null) toReturn = new ArrayList<String[]>();
                String Studioid = rs.getString("studioid");
                String studioName = rs.getString("sName");
                String SessionId = rs.getString("sessionID");
                String artist = rs.getString("stageName");
                Date date =  new Date(rs.getTimestamp("sessionStartDate").getTime());
                SimpleDateFormat dft = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                dft.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
                toReturn.add(new String[]{Studioid ,studioName, SessionId, dft.format(date).toString(), artist});
            }
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return toReturn;
    }
    
    /**
     * This method gets all musician details
     * @return
     */
    public static Musician getMuicianDetails(String id){
        Musician m = null;
        
        String qry = "SELECT Musician.*, Freelancer.*\n" +
                "FROM Freelancer INNER JOIN Musician ON Freelancer.[FreelancerID] = Musician.[MusicianID]\n" +
                "WHERE (((Musician.MusicianID)=\""+id+"\"));";
        
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            if (rs.next()){
                String sID = rs.getString("Freelancerid");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String stagename = rs.getString("stagename");
                Date d = new Date(rs.getTimestamp("birthdate").getTime());
                String email = rs.getString("strEmail");
                String password = rs.getString("password");
                int status = rs.getInt("status");
                String filepic = rs.getString("filepic");
                int pay = rs.getInt("payroll");
                int expert = rs.getInt("expertin");
                m = new Musician(sID ,firstname, lastname, stagename, pay, expert, 0, d, email, password, status);
                m.setFile(rs.getString("filePic"));
                return m;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
    }
    
    
    /**
     * this method gets all soundman details
     * @return
     */
    public static Soundman getSoundmanDetails(String id){
        Soundman s = null;
        
        String qry = "SELECT Freelancer.*, Soundman.*, Soundman.SoundmanID\n" +
                "FROM Freelancer INNER JOIN Soundman ON Freelancer.FreelancerID = Soundman.SoundmanID\n" +
                "WHERE (((Soundman.SoundmanID)=\""+id+"\"));";
        
        ResultSet rs = iRecord.getDB().query(qry);
        
        try {
            if (rs.next()){
                String sID = rs.getString("Freelancerid");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String stagename = rs.getString("stagename");
                Date d = new Date(rs.getTimestamp("birthdate").getTime());
                String email = rs.getString("strEmail");
                String password = rs.getString("password");
                int status = rs.getInt("status");
                String filepic = rs.getString("filepic");
                boolean isProducer = rs.getBoolean("isproducer");
                boolean isMixtech = rs.getBoolean("ismixtech");
                boolean isMastertech = rs.getBoolean("ismastertech");
                double downpay = rs.getDouble("downpayment");
                double fullpay = rs.getDouble("fullpayment");
                s = new Soundman(sID, firstname, lastname, stagename, isProducer, isMixtech, isMastertech, downpay, fullpay, 0, d, email, password, status);
                s.setFile(rs.getString("filePic"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s;
    }
    
    /**
     * This method updates musician details
     * @param m
     * @return
     */
    public static void updateMusician(Musician s){
        
        java.sql.Timestamp eDate = new java.sql.Timestamp (s.getBirthdate().getTime());
        
        String qry1 = "UPDATE Freelancer"
                + " SET firstName=\""+s.getFirstName()+"\", lastName=\""+s.getLastName()+"\", stageName=\""+s.getStageName()+"\", birthDate=\"" +eDate+ "\", strEmail=\""+s.getEmail() +"\", Password=\""+s.getPassword()+"\", Status="+s.getStatus()+ ", filePic=\""+s.getPicPath()+"\" "
                + " WHERE FreelancerID=\"" +s.getFreelancerID() +"\"";
        
        String qry2 = "UPDATE Musician"
                + " SET Payroll="+s.getPayRoll()+" , expertIn="+s.getExpertise().intValue()
                + " WHERE MusicianID=\"" + s.getFreelancerID() +"\"";
        
        iRecord.getDB().executeUpadate(qry1);
        iRecord.getDB().executeUpadate(qry2);
        
        
    }
    
    /**
     * this method updates musician details
     * @param s
     * @return
     */
    public static void updateSoundman(Soundman s){
             
        java.sql.Timestamp eDate = new java.sql.Timestamp (s.getBirthdate().getTime());
        
        String qry1 = "UPDATE Freelancer"   
                + " SET firstName=\""+s.getFirstName()+"\", lastName=\""+s.getLastName()+"\", stageName=\""+s.getStageName()+"\", birthDate=\"" +eDate+ "\", strEmail=\""+s.getEmail() +"\", Password=\""+s.getPassword()+"\", Status="+s.getStatus()+ ", filePic=\""+s.getPicPath()+"\" "
                + " WHERE FreelancerID=\"" +s.getFreelancerID() +"\"";
        
        String qry2 = "UPDATE Soundman" 
                + " SET isProducer="+s.getIsProducer()+" ,isMixTech=" +s.getIsMixTech()+ ", isMasterTech=" +s.getIsMasterTech()+ ",downPayment=" +s.getDownPayment()+ ", FullPayment=" +s.getFullPayment()+" "
                + " WHERE SoundmanID=\"" + s.getFreelancerID() +"\"";
        
        iRecord.getDB().executeUpadate(qry1);
        iRecord.getDB().executeUpadate(qry2);
        
          
        
    }
    /**
     * ===========================================================
     * public class InsertPicture
     * {
     * public static void main(String[] args) throws Exception, IOException
     * {
     * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     * String url="jdbc:odbc:MyDsn";
     * Connection conn=DriverManager.getConnection(url);
     * String INSERT_PICTURE = "insert into Img(ID,Image) values (?, ?)";
     *
     * FileInputStream fis = null;
     * PreparedStatement ps = null;
     * try
     * {
     * conn.setAutoCommit(false);
     * File file = new File("laura.jpg");
     * fis = new FileInputStream(file);
     * ps = conn.prepareStatement(INSERT_PICTURE);
     * ps.setString(1, "001");
     * ps.setBinaryStream(2, fis, (int) file.length());
     * ps.executeUpdate();
     * conn.commit();
     * }
     * finally
     * {
     * ps.close();
     * fis.close();
     * }
     * }
     * }
     *
     *
     */
    
    
    
    
}
