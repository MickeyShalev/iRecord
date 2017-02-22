/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import iRecord.utilities.EAuth;

/**
 *
 * @author Administrator
 */
public class Person {
    private String ID, stageName, password, email;
    private EAuth userAuth = null;
    
    //===================================== Constructors ===============================================
    
    public Person(String ID, String stageName, String password, EAuth userAuth){
        this.ID=ID;
        this.stageName = stageName;
        this.password=password;
        this.userAuth=userAuth;
        
    }
    
        public Person(String ID, String stageName, String password, String email, EAuth userAuth){
        this.ID=ID;
        this.stageName = stageName;
        this.password=password;
        this.userAuth=userAuth;
        this.email = email;
        
    }
    
    
    
    public Person(String id){
        this.ID = id;
    }

    //================================= Stetters and Getters ============================================
    
    public EAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(EAuth userAuth) {
        this.userAuth = userAuth;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setStageName(String name){
        this.stageName = name;
    }
    
    public String getStageName(){
        return this.stageName;
    }

    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
}
