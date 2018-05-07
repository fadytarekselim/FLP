public class GainPossession extends TeamGameEvent {
    
    public GainPossession(){
        
        super();
        
    }
    
    public String toString() {
        return "Won possession ";
    }
    
    public TeamGameEvent[] getNextEvents() {
        TeamGameEvent theEvent[] = { new GainPossession(), new Pass(), new Dribble(), new Shoot()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return true;
    }
    
}
