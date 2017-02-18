package iRecord.Controller;

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
    
    public static int addStudio(){
        int status = -1;
        
        getStudioNextKey();
        String qry = "INSERT INTO Studio (StudioID, sName, sAddress, sEmail, sPhoneNum, sDesc)"
                + " VALUES (11, \"BigBang\", \"Somewhere\", \"qwe@qwe.qwe\",\"123456789\", \"Amazing\")";
        
        
        if (iRecord.getDB().updateReturnID(qry) < 0) {                                      //
            status = -1;
        }



        return status;
    }
    
    
    public static void getStudioNextKey(){
        int number = 0;
        
        ResultSet rs = iRecord.getDB().query("SELECT MAX(StudioID) FROM Studio");
        System.out.println(rs);
        //if exists return ture
        try {
            if (rs.next()){
                number = 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //return number;
    }
    
    
    public static void addRoom(){
        
        
    }
    
}
