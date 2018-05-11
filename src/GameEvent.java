public abstract class GameEvent {
    // To be Implemented by the events
    public abstract GameEvent[] getNextEvents();
    public abstract boolean changePlayer();
    public abstract boolean changeTeam();
    
    // Declarations and Methods to be used by the events
    private Team theTeam;
    private Player thePlayer;
    private int theTime;
    int ballPos;

    public GameEvent() {}

    public Team getTheTeam() {
        return theTeam;
    }

    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public int getTheTime() {
        return theTime;
    }

    public void setTheTime(int theTime) {
        this.theTime = theTime;
    }

    public int getBallPos() {
        return ballPos;
    }

    public void setBallPos(int ballPos) {
        this.ballPos = ballPos + (Settings.PITCH_LENGTH - ballPos)/8;
    }
    
    public void reverseBallPos(){
        this.ballPos = Settings.PITCH_LENGTH - this.ballPos;
    } 
}
