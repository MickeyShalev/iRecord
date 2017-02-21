/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import iRecord.Controller.SessionManager;
import iRecord.iRecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Session {
    private Integer SessionID;
    private Studio stud;
    private Artist art;
    private Date sessionStartDate, sessionEndDate;
    private List<Room> roomList;
    private List<Soundman> chosenSoundmen;
    private Map<Musician, Room> chosenMusicians;
    private double totalCost;

    public Session(Studio stud, Artist art, Date sessionStartDate, Date sessionEndDate, List<Room> roomList, List<Soundman> chosenSoundmen, Map<Musician, Room> chosenMusicians, double totalCost) {
        setID();
        this.stud = stud;
        this.art = art;
        this.sessionStartDate = sessionStartDate;
        this.sessionEndDate = sessionEndDate;
        this.roomList = roomList;
        this.chosenSoundmen = chosenSoundmen;
        this.chosenMusicians = chosenMusicians;
        this.totalCost = totalCost;
        SessionManager.addSession(this);
        
    }
    
    public void setID(){
        ResultSet qry = iRecord.getDB().query("select TOP 1 SessionID from Session order by SessionID desc");
        try {
            while(qry.next())
                setSessionID(qry.getInt(1)+1);
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer getSessionID() {
        return SessionID;
    }

    public void setSessionID(Integer SessionID) {
        this.SessionID = SessionID;
    }

    public Studio getStud() {
        return stud;
    }

    public void setStud(Studio stud) {
        this.stud = stud;
    }

    public Artist getArt() {
        return art;
    }

    public void setArt(Artist art) {
        this.art = art;
    }

    public Date getSessionStartDate() {
        return sessionStartDate;
    }

    public void setSessionStartDate(Date sessionStartDate) {
        this.sessionStartDate = sessionStartDate;
    }

    public Date getSessionEndDate() {
        return sessionEndDate;
    }

    public void setSessionEndDate(Date sessionEndDate) {
        this.sessionEndDate = sessionEndDate;
    }

    public List<Room> getRoomList() {
        return roomList;
    }
    
    public double getCost(){
        return this.totalCost;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Soundman> getChosenSoundmen() {
        return chosenSoundmen;
    }

    public void setChosenSoundmen(List<Soundman> chosenSoundmen) {
        this.chosenSoundmen = chosenSoundmen;
    }

    public Map<Musician, Room> getChosenMusicians() {
        return chosenMusicians;
    }

    public void setChosenMusicians(Map<Musician, Room> chosenMusicians) {
        this.chosenMusicians = chosenMusicians;
    }
    
 
    
}
