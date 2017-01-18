/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import iRecord.utilities.EArtistStatus;
import iRecord.utilities.EAuth;
import java.sql.Date;

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
    
}
