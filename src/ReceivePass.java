public class ReceivePass extends GameEvent {
    
    public ReceivePass() {}
    
    public String toString() {
        return "Receive pass ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = { new Dribble(), new GainPossession(), new Shoot(), new Pass()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return false;
    }   
}
