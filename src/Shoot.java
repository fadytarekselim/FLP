public class Shoot extends TeamGameEvent {
    
    // At the simplest, if successful dribbling moves towards the other teams goal
    public Shoot(){
        
        // No change in ballPoss until next event; Goal or Kickout(save)
        
    }
    
    public String toString() {
        return "Shoots ";
    }
    
    public TeamGameEvent[] getNextEvents() {
        TeamGameEvent theEvent[] = { new Goal(), new Kickout()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }
    
        /**
     * @param ballPos the ballPos to set
     */
    public void setBallPos(int currBallPos) {
        //super.setBallPos(currBallPos);
        super.ballPos = currBallPos;

    }
    
}
