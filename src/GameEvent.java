public abstract class GameEvent {
    
    private Team theTeam;
    private Player thePlayer;
    private int theTime;
    int ballPos;

    
    public GameEvent(){
        
        // Eventually only for Dribble?

        
    }
    
    /**
     * @return the theTeam
     */
    public Team getTheTeam() {
        return theTeam;
    }

    /**
     * @param theTeam the theTeam to set
     */
    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }

    /**
     * @return the thePlayer
     */
    public Player getThePlayer() {
        return thePlayer;
    }

    /**
     * @param thePlayer the thePlayer to set
     */
    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    /**
     * @return the theTime
     */
    public int getTheTime() {
        return theTime;
    }

    /**
     * @param theTime the theTime to set
     */
    public void setTheTime(int theTime) {
        this.theTime = theTime;
    }
    
    public abstract GameEvent[] getNextEvents();
    
    public abstract boolean changePlayer();
    
    public abstract boolean changeTeam();

    /**
     * @return the ballPos
     */
    public int getBallPos() {
        return ballPos;
    }

    /**
     * @param ballPos the ballPos to set
     */
    public void setBallPos(int ballPos) {
        this.ballPos = ballPos + (Settings.PITCH_LENGTH - ballPos)/8;
    }
    
    
    public void reverseBallPos(){
        this.ballPos = Settings.PITCH_LENGTH - this.ballPos;
    }

    
}
