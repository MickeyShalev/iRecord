/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import iRecord.utilities.EAuth;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author nisan
 */
public class Freelancer extends Person{
    private String firstName, lastName, picPath;
    private int priority, status;
    Date birthdate;

    //================================== Constructors =================================================
    public Freelancer(String ID, String firstName, String lastName, String stageName, String email) {
        super(ID, stageName, " ", EAuth.Freelancer);
        this.firstName = firstName;
        this.lastName = lastName;
        super.setEmail(email);
    }
    
    
        public Freelancer(String ID, String firstName, String lastName, String stageName, String email, String password, int status) {
        super(ID, stageName, password, EAuth.Freelancer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        super.setEmail(email);
    }
        
        public Freelancer(String ID, String firstName, String lastName, String stageName, String email, String password, int status, Date birthdate) {
        super(ID, stageName, password, EAuth.Freelancer);
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        super.setEmail(email);
        this.birthdate = birthdate;
    }

    public Freelancer(String id){
        super(id);
    }
    
    //================================= Setters and Getters ================================================
    public String getFreelancerID(){
        return super.getID();
    }
    
    public void setPriority(int p){
        this.priority = p;
    }
    
    public int getPriority(){
        return this.priority;
    }
    

    public String getFirstName() {
        return firstName;
    }
    

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(getID());
        return hash;
    }
    
    public String getStageName(){
        return super.getStageName();
    }
    
    public void setStageNmae(String name){
        super.setStageName(name);
    }
    
    public int getStatus(){
        return this.status;
    }
    
    public String getPassword(){
        return super.getPassword();
    }
    
    public String getPicPath(){
        return this.picPath;
    }
    
    public void setPicPath(String path){
        this.picPath = path;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Freelancer other = (Freelancer) obj;
        if (!Objects.equals(this.getID(), other.getID())) {
            return false;
        }
        return true;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
