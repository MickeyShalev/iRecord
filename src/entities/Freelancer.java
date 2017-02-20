/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author nisan
 */
public class Freelancer {
    String FreelancerID, firstName, lastName, stageName, email;
    Integer priority;

    public Freelancer(String FreelancerID, String firstName, String lastName, String stageName, Integer priority) {
        this.FreelancerID = FreelancerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
        this.priority = priority;
    }
    
    public Freelancer(String FreelancerID, String firstName, String lastName, String stageName, Integer priority, String email) {
        this.FreelancerID = FreelancerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
        this.priority = priority;
        this.email = email;
    }

    public Freelancer(String FreelancerID){
        this.FreelancerID=FreelancerID;
        this.priority=0;
    }
    
    
    public Integer getPriority() {
        return priority;
    }

    public String getEmail(){
        return this.email;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getFreelancerID() {
        return FreelancerID;
    }

    public void setFreelancerID(String FreelancerID) {
        this.FreelancerID = FreelancerID;
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

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.FreelancerID);
        return hash;
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
        if (!Objects.equals(this.FreelancerID, other.FreelancerID)) {
            return false;
        }
        return true;
    }
    
    
    
}
