/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import iRecord.utilities.EArtistStatus;
import iRecord.utilities.EAuth;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Artist extends Person {

    

    private String emailAddr = "";
    private String ID = "";
    private String stageName= "";
    private java.sql.Date dateExpired;
    public Artist(String ID, String strStageName, String strPasswd, java.sql.Date dateExpired, EAuth authType){
        super(ID, strStageName, "", strPasswd, authType);
        setEmailAddr(emailAddr);
        setID(ID);
        setStageName(stageName);
        setDateExpired(dateExpired);
        
    
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }


    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }
    
    public List<java.sql.Date> getUnavailableDates(){
       List<java.sql.Date> list = new ArrayList<java.sql.Date>();
       ResultSet qry = iRecord.getDB().query("select sessionStartDate AS date from Session where ArtistID=\""+getID()+"\"");
        try {
            while(qry.next()){
                java.sql.Date d = qry.getDate("date");
               java.sql.Date dateNow = new java.sql.Date(Calendar.getInstance().getTime().getTime());
               list.add(d);
                
            }} catch (SQLException ex) {
            Logger.getLogger(Artist.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return list;
       
    }
    
}
