/* Author: Fady Tarek Selim
 * Developer? Insert your name here:
 * 1- 
 * */

public class GainPossession extends GameEvent {
    
    public GainPossession(){       
        super();
    }
    
    public String toString() {
        return "Won possession ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = { new GainPossession(), new Pass(), new Dribble(), new Shoot()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return true;
    }
    
}
