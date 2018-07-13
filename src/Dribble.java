/* Author: Fady Tarek Selim
 * Developer? Insert your name here:
 * 1- 
 * */

public class Dribble extends GameEvent {
    
    // At the simplest, if it is a successful dribble, it moves towards the other teams goal
    public Dribble(){
        super();
    }
    
    public String toString() {
        return "Dribble ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = { new GainPossession(), new Shoot(), new Pass()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }
    
}
