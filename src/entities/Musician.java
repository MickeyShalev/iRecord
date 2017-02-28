
package entities;

import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Musician extends Freelancer {
    private double payRoll;
    private int expertise;
    private Date birthdDate;
    private String fileString;
    
    //==================================== Constructors ===================================================
    public Musician(String FreelancerID, String firstName, String lastName, String stageName, double payRoll, int expertise, int priority, Date birthdate, String email, String password, int status) {
        super(FreelancerID, firstName, lastName, stageName, email, password, status);
        this.payRoll = payRoll;
        this.expertise = expertise;
        this.birthdDate = birthdate;
    }
    
    public Musician(String FreelancerID){
        super(FreelancerID);
        
    }
    
    //this contructor is dedicated to session controller
    public Musician(String id, String fname, String lname, String stageName, double pay, int expert, int p) {
        super(id, fname, lname, stageName, " ");
        this.payRoll = payRoll;
        this.expertise = expertise;
        setPriority(p);
        
    }
    
    //=================================== Setters and Getters ===========================================
    public Double getPayRoll() {
        return payRoll;
    }
    
    public void setPayRoll(Double payRoll) {
        this.payRoll = payRoll;
    }
    
    public Integer getExpertise() {
        return expertise;
    }
    
    public Date getBirthdate(){
        return this.birthdDate;
    }
    
    public void setExpertise(Integer expertise) {
        this.expertise = expertise;
    }
    
    public String getExpertiseString(){
        ResultSet qry = iRecord.getDB().query("select eField from Expertise where ExpertiseID="+getExpertise());
        try {
            while(qry.next()){
                return qry.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Musician.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
    
   
    
    
    public void setFileString(String file){
        this.fileString = file;
    }
    
    public String getFileString(){
        return this.fileString;
    }
    
}
