public class Team {
    // Declarations
    private String teamName;
    private Player[] playerArray;
    private int pointsTotal;
    private int goalsTotal;
    private int id = 0;
    private String detailType = "Team";
    
    // Constructors
    public Team() {
    	
    }
    
    public Team(String teamName) {
        this.teamName = teamName;
    }
    
    public Team(String teamName, Player[] players) {
        this(teamName);
        this.playerArray = players;
    }

    // Setters & Getters
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }
    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }
    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public int getGoalsTotal() {
        return goalsTotal;
    }
    public void setGoalsTotal(int goalsTotal) {
        this.goalsTotal = goalsTotal;
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
    
    // Methods
    public String toString(){
        return teamName;
    }
    
    // The code below shows our implementation to the random selections of events
    public TeamGameEvent getNextPlayAttempt(TeamGameEvent currEvent){
        
        TeamGameEvent[] possEvents = currEvent.getNextEvents();
        currEvent = possEvents[(int) (Math.random() * (possEvents.length))];
        
        return currEvent;
    }
    
    // 1 means the method's input is the winner in our implementation
    public int compareTo(Team theTeam){
        int returnValue = -1;
        
        if (this.getPointsTotal()< theTeam.getPointsTotal()) {
            returnValue = 1;
        } 
        else if (this.getPointsTotal() == theTeam.getPointsTotal()) {
            if (this.getGoalsTotal()< theTeam.getGoalsTotal())
                returnValue = 1;
        }   
        
        return returnValue;
    }
    
    // Updating Goals & Total Points
    public void incGoalsTotal(int goals){
        this.setGoalsTotal(this.getGoalsTotal() + goals);
    }

    public void incPointsTotal(int points){
        this.pointsTotal += points;
    }
}
