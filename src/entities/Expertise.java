package entities;

/**
 *
 * @author micke
 */
public class Expertise {
    private int num;
    private String name;
    
    
    public Expertise(int num, String name){
        this.num = num;
        this.name = name;
    }
    
    
    public String getName(){
        return this.name;
    }
    
    public int getNum(){
        return this.num;
    }
    
    public void setNum(int num){
        this.num = num;
    }
    
    public void setname(String name){
        this.name = name;
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
        final Expertise other = (Expertise) obj;
        if (this.num != other.num) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 1 * hash + this.num;
        return hash;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
