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
public class Soundman extends Freelancer {
    Boolean isProducer, isMixTech, isMasterTech;
    Double downPayment, fullPayment;

    public Soundman(String FreelancerID, String firstName, String lastName, String stageName, Boolean isProducer, Boolean isMixTech, Boolean isMasterTech, Double downPayment, Double fullPayment, Integer priority) {
        super(FreelancerID, firstName, lastName, stageName, priority);
        this.isProducer = isProducer;
        this.isMixTech = isMixTech;
        this.isMasterTech = isMasterTech;
        this.downPayment = downPayment;
        this.fullPayment = fullPayment;
    }

    public Soundman(String FreelancerID){
        super(FreelancerID);
    }
    
    public Boolean getIsProducer() {
        return isProducer;
    }

    public void setIsProducer(Boolean isProducer) {
        this.isProducer = isProducer;
    }

    public Boolean getIsMixTech() {
        return isMixTech;
    }

    public void setIsMixTech(Boolean isMixTech) {
        this.isMixTech = isMixTech;
    }

    public Boolean getIsMasterTech() {
        return isMasterTech;
    }

    public void setIsMasterTech(Boolean isMasterTech) {
        this.isMasterTech = isMasterTech;
    }

    public Double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Double downPayment) {
        this.downPayment = downPayment;
    }

    public Double getFullPayment() {
        return fullPayment;
    }

    public void setFullPayment(Double fullPayment) {
        this.fullPayment = fullPayment;
    }

    @Override
    public String toString() {
        return getStageName();
    }
    
    public void setRoles(Boolean isProducer, Boolean isMixTech, Boolean isMasterTech){
        this.isProducer=isProducer;
        this.isMixTech=isMixTech;
        this.isMasterTech=isMasterTech;
    }
    
    public Integer getRoleCount(){
        int counter=0;
        if(isMasterTech) counter++;
        if(isMixTech) counter++;
        if(isProducer) counter++;
        return counter;
    }
    
    
    
    
    
}
