/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Room {
    Studio studio;
    Integer RoomNum, maxMusicians;
    Double hourRate;
    Boolean hasIsolation;

    public Room(Studio studio, Integer RoomNum, Double hourRate, Integer maxMusicians, Boolean hasIsolation) {
        this.studio = studio;
        this.RoomNum = RoomNum;
        this.hourRate = hourRate;
        this.maxMusicians = maxMusicians;
        this.hasIsolation = hasIsolation;
    }

    public Room(Integer RoomNum){
        this.RoomNum = RoomNum;
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

    public Double getHourRate() {
        return hourRate;
    }

    public void setHourRate(Double hourRate) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.RoomNum);
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
        final Room other = (Room) obj;
        if (!Objects.equals(this.RoomNum, other.RoomNum)) {
            return false;
        }
        return true;
    }
    
    
    
}
