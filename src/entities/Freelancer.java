/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author nisan
 */
public class Freelancer {
    String FreelancerID, firstName, lastName, stageName;

    public Freelancer(String FreelancerID, String firstName, String lastName, String stageName) {
        this.FreelancerID = FreelancerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
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
    
}
