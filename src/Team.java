public class Team {
    
    private String teamName;
    private Player[] playerArray;
    private int pointsTotal;
    private int goalsTotal;
    private int id = 0;
    private String detailType = "Team";
    
    public int compareTo(Object theTeam){
        int returnValue = -1;
        if (this.getPointsTotal()< ((Team)theTeam).getPointsTotal()) {
            returnValue = 1;
        } else if (this.getPointsTotal() == ((Team)theTeam).getPointsTotal()){
            if (this.getGoalsTotal()< ((Team)theTeam).getGoalsTotal()) {
                returnValue = 1;
            } 
        }
        return returnValue;
    }
    
    public void incGoalsTotal(int goals){
        this.setGoalsTotal(this.getGoalsTotal() + goals);
    }

    public void incPointsTotal(int points){
        this.pointsTotal += points;
    }
    
    public Team(String teamName) {
        this.teamName = teamName;
    }
    
    public Team(String teamName, Player[] players) {
        this(teamName);
        this.playerArray = players;
    }
    
    public Team() {}

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the playerArray
     */
    public Player[] getPlayerArray() {
        return playerArray;
    }

    /**
     * @param playerArray the playerArray to set
     */
    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    /**
     * @return the pointsTotal
     */
    public int getPointsTotal() {
        return pointsTotal;
    }

    /**
     * @param pointsTotal the pointsTotal to set
     */
    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    /**
     * @return the goalsTotal
     */
    public int getGoalsTotal() {
        return goalsTotal;
    }

    /**
     * @param goalsTotal the goalsTotal to set
     */
    public void setGoalsTotal(int goalsTotal) {
        this.goalsTotal = goalsTotal;
    }
    
    public String toString(){
        return teamName;
    }

    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the getDetailType
     */
    public String getGetDetailType() {
        return detailType;
    }

    /**
     * @param getDetailType the getDetailType to set
     */
    public void setGetDetailType(String detailType) {
        this.detailType = detailType;
    }
    
    
    // Below code shows random selection of attempt
    public GameEvent getNextPlayAttempt(GameEvent currEvent){
        
        GameEvent[] possEvents = currEvent.getNextEvents();
        currEvent = possEvents[(int) (Math.random() * (possEvents.length))];
        
        return currEvent;
    }
    
    
}
