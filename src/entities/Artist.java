/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import iRecord.Controller.XMLManager;
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
    private java.sql.Date dateExpired;
    
    //======================================= Constructors ==========================================
    public Artist(String ID, String strStageName, String strPasswd, java.sql.Date dateExpired, EAuth authType){
        super(ID, strStageName, strPasswd, authType);
        this.dateExpired = dateExpired;

    }
    
    
        public Artist(String ID, String strStageName, String mail, String strPasswd, java.sql.Date dateExpired, EAuth authType){
        super(ID, strStageName, strPasswd, authType);
        super.setEmail(mail);
        this.dateExpired = dateExpired;
        
        }

        
    //===================================== Setters and Getters ===========================================    
    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }
    
    @Override
    public String getID(){
        return super.getID();
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
        
        for(Timestamp d : XMLManager.importXML(getID())){
            System.err.println("Received date from XML: "+d.toGMTString());
            java.sql.Date date = new java.sql.Date(d.getTime());
            date.setDate((date.getDate())-1);
            list.add(date);
        }
       
        return list;
       
    }
    
}
