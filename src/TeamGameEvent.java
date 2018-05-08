public abstract class TeamGameEvent {
	// Abstract methods to be Implemented by the specific event
	public abstract TeamGameEvent[] getNextEvents();
    public abstract boolean changePlayer();
    public abstract boolean changeTeam();
    
    // Declarations
    private Team theTeam;
    private Player thePlayer;
    private int theTime;
    int ballPos;

    // Getters & Setters
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
        this.ballPos = ballPos + (ProjectRun.PITCH_LENGTH - ballPos)/8;
    }
    
    // Returning the ball position in the eyes of the opponent
    public void reverseBallPos(){
        this.ballPos = ProjectRun.PITCH_LENGTH - this.ballPos;
    }

}
