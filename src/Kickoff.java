/* Author: Fady Tarek Selim
 * Developer? Insert your name here:
 * 1- 
 * */

public class Kickoff extends GameEvent {    
    public Kickoff() {}

    public String toString() {
        return "Kickoff ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = {new ReceivePass(), new GainPossession()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return true;
    }

    public void setBallPos(int ballPos) {
       super.ballPos = 50;
    }
}
