package iRecord.Controller;

import entities.Freelancer;
import entities.Musician;
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
        
        java.sql.Timestamp eDate = new java.sql.Timestamp (s.getBirthdate().getTime());
         
        //insert soundman to freelancer table - query
        String qry1 = "INSERT INTO Freelancer (FreelancerID, firstName, lastName, stageName, birthDate, strEmail, filePic)"
                + " VALUES (\"" +s.getFreelancerID() +"\", \""+s.getFirstName()+"\" ,\""+s.getLastName()+"\", \""+s.getStageName()+"\",\"" + eDate + "\", \""+s.getEmail() +"\", ?\")";
        
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
        
        
        
        return status;
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
    
    
    
    /**
===========================================================
public class InsertPicture
{
        public static void main(String[] args) throws Exception, IOException
        {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                String url="jdbc:odbc:MyDsn";
                Connection conn=DriverManager.getConnection(url);
                String INSERT_PICTURE = "insert into Img(ID,Image) values (?, ?)";

                FileInputStream fis = null;
                PreparedStatement ps = null;
                try
                {
                        conn.setAutoCommit(false);
                        File file = new File("laura.jpg");
                        fis = new FileInputStream(file);
                        ps = conn.prepareStatement(INSERT_PICTURE);
                        ps.setString(1, "001");
                        ps.setBinaryStream(2, fis, (int) file.length());
                        ps.executeUpdate();
                        conn.commit();
                }
                finally
                {
                        ps.close();
                        fis.close();
                }
        }
}

     
     */
    
}
