package entities;

/**
 *
 * @author micke
 */
public enum Expertiese {

        Accordionist(1), Bassoonist(2), Cellist(3), Clarinetist(4), ElectronicMusician(5), 
        Flautist(6), Guitarist(7), Keyboardist(8), Organist(9), Pianist(10), Percussionist(11),
        Saxophonist(12), Trumpeter(13), Violinist(14), Violist(15) , Bassist(16),Harpist(17) , BouzoukiPlayer(18), 
        Hornist(19), Euphoniumist(20), OrganGrinder(21), Drummer(22), Bandurist(23);


        
    //Vriable
    private int value;
    
    //Construcor
    private Expertiese(int value) {
        this.value = value;
    }
    
    //Getter
    public int getValue() {
        return value;
    }
    
}
