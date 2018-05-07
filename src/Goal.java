public class Goal extends TeamGameEvent {
    
    public Goal(){
       
    }
    public String toString() {
        return "GOAL! ";
    }
     
    public TeamGameEvent[] getNextEvents() {
        TeamGameEvent theEvent[] = {new Kickoff()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }
    
    
    // Little bit of a hack maybe as ballPos not used.
    public void setBallPos(int ballPos) {
       //super.setBallPos(100);
        super.ballPos = 100;
    }
     
}
