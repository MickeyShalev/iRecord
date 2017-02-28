/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.ResultSet;
import java.util.List;

import iRecord.*;
import iRecord.utilities.EAuth;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class Studio {
    private String sName, sAddress, sEmail, sPhoneNum, sDesc, password;
    private Integer sID;
    private Map<Integer, Room> sRooms;
    private EAuth studAuth = null;
//    public Studio(Integer sID, String sName, String sAddress, String sEmail, String sPhoneNum, String sDesc){
//        this.s
//    }

    public Studio(String sName, String sAddress, String sEmail, String sPhoneNum, String sDesc, Integer sID) {
        this.sName = sName;
        this.sAddress = sAddress;
        this.sEmail = sEmail;
        this.sPhoneNum = sPhoneNum;
        this.sDesc = sDesc;
        this.sID = sID;
        this.sRooms = aquireRooms();
        
    }
    
        public Studio(String sName, String sAddress, String sEmail, String sPhoneNum, String sDesc, Integer sID, String password) {
        this.sName = sName;
        this.sAddress = sAddress;
        this.sEmail = sEmail;
        this.sPhoneNum = sPhoneNum;
        this.sDesc = sDesc;
        this.sID = sID;
        this.password = password;
        this.sRooms = aquireRooms();
        
    }
    
    public Studio(String sName){
        this.sName = sName;
    }

    @Override
    public String toString() {
        return sName;
    }
    
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsPhoneNum() {
        return sPhoneNum;
    }

    public void setsPhoneNum(String sPhoneNum) {
        this.sPhoneNum = sPhoneNum;
    }

    public String getsDesc() {
        return sDesc;
    }

    public void setsDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    public Integer getsID() {
        return sID;
    }

    public void setsID(Integer sID) {
        this.sID = sID;
    }

    public Map<Integer, Room> getsRooms() {
        return sRooms;
    }

    public void setsRooms(Map<Integer, Room> sRooms) {
        this.sRooms = sRooms;
    }
    
    
    public void setAuth(EAuth auth){
        this.studAuth = auth;
    }
    
    public EAuth getAuth(){
        return this.studAuth;
    }
    
    public Map<Integer, Room> aquireRooms(){
        Map<Integer, Room> tmpList = new HashMap<Integer, Room>();
        ResultSet qry = iRecord.getDB().query("select * from Room where StudioID=\""+getsID()+"\"");
        try {
            while(qry.next()){
                Integer RoomID = qry.getInt(1);
                Double hourRate = qry.getDouble(3);
                Integer maxMusicians = qry.getInt(4);
                Boolean hasIsolation = qry.getBoolean(5);
                tmpList.put(RoomID, new Room(this, RoomID, hourRate, maxMusicians, hasIsolation));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Studio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tmpList;
                
                
    }

    public String getPass() {
        return this.password;
    }
    
    
    public void setPass(String pass){
        this.password = pass;
    }
    
}
