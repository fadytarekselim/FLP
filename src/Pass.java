public class Pass extends TeamGameEvent {
    
    public Pass(){
        
        super();
        
    }
    
    public String toString() {
        return "Pass attempt ";
    }
    
    public TeamGameEvent[] getNextEvents() {
        TeamGameEvent theEvent[] = { new ReceivePass(), new GainPossession()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }
    
}
