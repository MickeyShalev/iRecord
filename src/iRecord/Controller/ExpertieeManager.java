package iRecord.Controller;

import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micke
 */
public class ExpertieeManager {
    
    /**
     * This method return list of all Expertise
     * @return 
     */
    public static HashMap<Integer, String> getInstrument(){
        HashMap<Integer, String> toReturn = new HashMap<Integer, String>();
       
        ResultSet rs = iRecord.getDB().query("SELECT Expertise.* FROM Expertise");
        
        try {
            while(rs.next()){
                toReturn.put(rs.getInt(1), rs.getString(2));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpertieeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return toReturn;
    }
    
    
    /**
     * This method adds new Expertise
     * @param num
     * @param name 
     */
    public static boolean addInstrument(int num, String name){
        boolean status = false;
        
        String qry = "INSERT INTO Expertise (ExpertiseID, eField) VALUES ("+num+", \""+name+"\")";
         
        if(isExists(name)){
            status = true;
        }
        
        return status;
    }
    
    
    /**
     * This method removes expertise only if no musician is using it
     * @param num 
     */
    public static boolean removeInstrument(int num, String name){
        boolean status = false;
        //chech if someone is using it
        String query = "SELECT Musician.[MusicianID], Musician.[Payroll], Musician.[expertIn] FROM Musician WHERE (((Musician.[expertIn])="+num+"))";
        ResultSet rs = iRecord.getDB().executeUpadate(query);
        
        
        try {
            if (rs.next()){
                //someone is using it - can't remove
                return false;
          
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExpertieeManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //none is using it - removing
        String qry = "DELETE FROM Expertise WHERE ExpertiseID = "+num+"";
        iRecord.getDB().executeUpadate(qry);
        
        
        if(!isExists(name)) status = true;
        
        
        return status;
    }
    
    
    public static boolean isExists(String name){
        boolean status = false;
        //chech if artist is already exists
        ResultSet rs = iRecord.getDB().query("SELECT Expertise.*, Expertise.eField\n" +
                "FROM Expertise\n" +
                "WHERE (((Expertise.eField)=\""+name+"\"))");
        
        //if exists return ture
        try {
            if (rs.next()){
                status = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
}
