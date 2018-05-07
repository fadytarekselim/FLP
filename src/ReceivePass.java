public class ReceivePass extends TeamGameEvent {
    
    public ReceivePass(){
        
        super();
        
    }    
    public String toString() {
        return "Receive pass ";
    }
    
    public TeamGameEvent[] getNextEvents() {
        TeamGameEvent theEvent[] = { new Dribble(), new GainPossession(), new Shoot(), new Pass()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return false;
    }
    
}
