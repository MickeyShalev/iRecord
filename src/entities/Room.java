/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Administrator
 */
public class Room {
    Studio studio;
    Integer RoomNum, hourRate, maxMusicians;
    Boolean hasIsolation;

    public Room(Studio studio, Integer RoomNum, Integer hourRate, Integer maxMusicians, Boolean hasIsolation) {
        this.studio = studio;
        this.RoomNum = RoomNum;
        this.hourRate = hourRate;
        this.maxMusicians = maxMusicians;
        this.hasIsolation = hasIsolation;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Integer getRoomNum() {
        return RoomNum;
    }

    public void setRoomNum(Integer RoomNum) {
        this.RoomNum = RoomNum;
    }

    public Integer getHourRate() {
        return hourRate;
    }

    public void setHourRate(Integer hourRate) {
        this.hourRate = hourRate;
    }

    public Integer getMaxMusicians() {
        return maxMusicians;
    }

    public void setMaxMusicians(Integer maxMusicians) {
        this.maxMusicians = maxMusicians;
    }

    public Boolean getHasIsolation() {
        return hasIsolation;
    }

    public void setHasIsolation(Boolean hasIsolation) {
        this.hasIsolation = hasIsolation;
    }
    
    
}
