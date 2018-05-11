import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
public class Game {
    
    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] events;
    private LocalDateTime theDateTime;
    
    private boolean detailAvailable = false;
    private int id = 0;
    private String detailType = "Game";
    
    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = theDateTime;
    }

    public void playGame() {
        ArrayList<GameEvent> eventList = new ArrayList<GameEvent>();
        Team currTeam;
        Player currPlayer;
        GameEvent currEvent = new Kickoff();
        currEvent.setBallPos(50);
        currEvent.setTheTeam(Math.random() > 0.5?homeTeam: awayTeam);
        currEvent.setThePlayer(currEvent.getTheTeam().getPlayerArray()[(int) (Math.random() * this.homeTeam.getPlayerArray().length)]);
        currEvent.setTheTime(0);
        eventList.add(currEvent);


        for (int i = 1; i <=Settings.GAME_LENGTH; i++){
            
            if (Math.random() > Settings.GAME_EVENT_FREQUENCY){
                
                currTeam = currEvent.getTheTeam();
                currPlayer = currEvent.getThePlayer();
                
                int currBallPos = currEvent.getBallPos(); // Need to get before setting up new Event
                
                currEvent = currTeam.getNextPlayAttempt(currEvent);

                currEvent.setBallPos(currBallPos );  // 8 could be random.
                
                if (currEvent.changeTeam()) {
                    currTeam = getOtherTeam(currTeam);
                    currEvent.reverseBallPos();
                }
                currEvent.setTheTeam(currTeam);
                
                ArrayList <Player> currPlayerList = new ArrayList<Player>(Arrays.asList(currEvent.getTheTeam().getPlayerArray()));
                currPlayerList.remove(currPlayer); 
                currEvent.setThePlayer(currEvent.changePlayer()?currPlayerList.get((int)(Math.random() * currPlayerList.size())):currPlayer);
                currEvent.setTheTime(i);
                eventList.add(currEvent);
            }
            this.events = new GameEvent[eventList.size()];
            eventList.toArray(events);
        }
    }
    
    public String getDescription(boolean showEvents) {

        // Announce the game
        StringBuilder returnString = new StringBuilder();
        returnString.append(this.getHomeTeam().getTeamName() + " vs. " +
                this.getAwayTeam().getTeamName() + " (" + 
                this.getTheDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE) + ")");
        returnString.append("\n");
        
        GameResult theResult = getGameResult();
      
        // Announce result
        if (theResult.isDrawnGame()){
            returnString.append("It's a draw!");
        } else  {
            returnString.append(theResult.getWinner().getTeamName());
            returnString.append(" win!");
        }
        returnString.append(" (" + theResult.getHomeTeamScore() + " - " + theResult.getAwayTeamScore() + ") \n");

        if (showEvents){
            for (GameEvent currEvent: this.getEvents()) {
                returnString.append(currEvent.getBallPos() + " : " + currEvent + "after " + currEvent.getTheTime() + " mins by " + currEvent.getThePlayer().getPlayerName() + " of " + currEvent.getTheTeam().getTeamName() + "\n");
            }  
        }

        return returnString.toString();
    }
    
    public String getDescription() {
        return getDescription(false);
    }
    
    public String getScore(){
        
        String theScore;
        GameResult theResult = getGameResult();
        theScore = theResult.getHomeTeamScore() + " - " + theResult.getAwayTeamScore();
        return theScore;
        
    }

    public Team getOtherTeam(Team currTeam){
        if (currTeam == homeTeam){
            currTeam = awayTeam;
        } else currTeam = homeTeam;
        return currTeam;
    }

    // Automated Code
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public GameEvent[] getEvents() {
        return events;
    }

    public void setEvents(GameEvent[] events) {
        this.events = events;
    }

    public LocalDateTime getLocalDateTime() {
        return getTheDateTime();
    }

    public void setLocalDateTime(LocalDateTime theDateTime) {
        this.setTheDateTime(theDateTime);
    }

    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }

    public GameResult getGameResult(){
        return new GameResult(this);
    }

    public String getDisplayDetail(){
        return getScore();
    }
    public boolean isDetailAvailable (){
        return detailAvailable;
    }
    public int getID(){
        return id;
    }
    public String getDetailType() {
        return detailType;
    }

    public void setDetailAvailable(boolean detailAvailable) {
        this.detailAvailable = detailAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGetDetailType() {
        return detailType;
    }

    public void setGetDetailType(String detailType) {
        this.detailType = detailType;
    }  
}
