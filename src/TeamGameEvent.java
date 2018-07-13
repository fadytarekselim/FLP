/* Author: Fady Tarek Selim
 * Developer? Insert your name here:
 * 1- 
 * */

public abstract class TeamGameEvent {
	// Abstract Methods
	public abstract TeamGameEvent[] getNextEvents();
    public abstract boolean changePlayer();
    public abstract boolean changeTeam();
    
    // Declarations
    private Team theTeam;
    private Player thePlayer;
    private int theTime;
    int ballPos;

    // Setters & Getters
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
    
    // The opponent view of the event
    public void reverseBallPos(){
        this.ballPos = Settings.PITCH_LENGTH - this.ballPos;
    }

}
