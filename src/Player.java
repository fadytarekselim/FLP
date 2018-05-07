public class Player {
    // Declarations
    private String playerName;
    private int goalsScored;
    
    // Constructors
    public Player() {}
    public Player(String playerName) {
        this.playerName = playerName;
    }
    
    // Setters & Getters
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGoalsScored() {
        return goalsScored;
    }
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }
    
    // Methods
    public void incGoalsScored() {
        this.goalsScored++;
    }
    
    public int compareTo(Object thePlayer){
        if (this.getGoalsScored() < ((Player)thePlayer).getGoalsScored())
            return 1;
        else
            return -1;
    }
}
