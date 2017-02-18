package iRecord.Controller;

import entities.Studio;
import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micke
 */
public class StudioAndRoomManager {
    
    public static int addStudio(Studio s){
        int status = -1;
        
        //Studio s = new Studio ("asd","asd","asd","asd","asd",6);
        String qry = "INSERT INTO Studio (StudioID, sName, sAddress, sEmail, sPhoneNum, sDesc)"
                + " VALUES ("+s.getsID().intValue() +",\""+s.getsName()+"\", \""+s.getsAddress()+"\", \""+s.getsEmail()+"\",\""+s.getsPhoneNum()+"\", \""+s.getsDesc()+"\")";
        
        
        if (iRecord.getDB().updateReturnID(qry) < 0) {                                     //
            status = -1;
        }
        
        return status;
    }
    
    /**
     * This method returns the next expectd index number
     * May return false if the hightest index is deleted manually from the DB
     * it won't affect anything because the numbering is automatic in the DB
     * @return 
     */
    public static int getStudioNextKey(){
        int number = 0;
        
        ResultSet rs = iRecord.getDB().query("SELECT MAX(StudioID) FROM Studio");
        
        
        //if exists return ture
        try {
            if (rs.next()){
                number = rs.getInt(1);
                //System.out.println(number);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return number+1;
    }
    
    
    public static void addRoom(){
        
        
    }
    
}
