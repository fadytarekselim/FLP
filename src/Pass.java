/* Author: Fady Tarek Selim
 * Developer? Insert your name here:
 * 1- 
 * */

public class Pass extends GameEvent {
    
    public Pass(){        
        super();        
    }
    
    public String toString() {
        return "Pass attempt ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = { new ReceivePass(), new GainPossession()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }   
}
