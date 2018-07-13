/* Author: Fady Tarek Selim
 * Developer? Insert your name here:
 * 1- 
 * */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class League {

    public Team[] createTeams(String teamNames, int teamSize) {
        PlayerDatabase playerDB = new PlayerDatabase();
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        
        for (int i =0; i < theTeams.length; i++){
             theTeams[i] = new Team(teamNameTokens.nextToken(), playerDB.getTeam(teamSize));
        }
        
        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        int daysBetweenGames = 0;
        
        ArrayList<Game> theGames = new ArrayList<Game>();
        
        for (Team homeTeam: theTeams){
            for (Team awayTeam: theTeams){
               if (homeTeam != awayTeam) {
                   daysBetweenGames += Settings.DAYS_BETWEEN_GAMES;
                   theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
               }       
            }
        }
        
        return (Game[]) theGames.toArray(new Game[1]);
    }

    public void setTeamStats(Team[] theTeams, Game[] theGames) {
       
    	for (Team currTeam: theTeams) {
            currTeam.setGoalsTotal(0);
            currTeam.setPointsTotal(0);
            for (Player currPlayer: currTeam.getPlayerArray()){
                currPlayer.setGoalsScored(0);
            }
        }
        
        for (Game currGame: theGames){
            GameResult theResult = currGame.getGameResult();
            if (theResult.isDrawnGame()) {
                currGame.getHomeTeam().incPointsTotal(Settings.DRAWN_GAME_POINTS);  
                theResult.getAwayTeam().incPointsTotal(Settings.DRAWN_GAME_POINTS);
            }
            else
                theResult.getWinner().incPointsTotal(Settings.WINNER_GAME_POINTS);
            
            theResult.getHomeTeam().incGoalsTotal(theResult.getHomeTeamScore());
            theResult.getAwayTeam().incGoalsTotal(theResult.getAwayTeamScore());   
        }
    }
    
    
    public void showBestTeam(Team[] theTeams) {
        Arrays.sort(theTeams);
        Team currBestTeam = theTeams[0];  
        System.out.println("\nTeam Points");
        
        for (Team currTeam: theTeams){
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : " + currTeam.getGoalsTotal());
        }
        
        System.out.println("\nWinner of the League is " + currBestTeam.getTeamName());
    }
    
    public void setPlayerStats(Game[] theGames) {
        for (Game currGame : theGames) {
            for (GameEvent currEvent : currGame.getEvents()) {
                if (currEvent instanceof Goal) {
                    currEvent.getThePlayer().incGoalsScored();
                }
            }
        }
    }
    
    public String showBestPlayerByLeague(Team[] theTeams, int teamSize){
        Player[] thePlayers = new Player[teamSize];
        Player bestPlayer = new Player();
        
	    for (Team currTeam: theTeams) {
	        thePlayers = currTeam.getPlayerArray();
	        
	        for (Player player: thePlayers) {
	            	if (player.getGoalsScored() > bestPlayer.getGoalsScored())
	            		bestPlayer = player;
	         }
	        
	     }
	    
        return bestPlayer.getPlayerName();
    }    
    
    public String showBestPlayerByTeam(Team[] theTeams, int teamSize){
    	System.out.println("");
    	String string = "";
    	Player[] thePlayers = new Player[teamSize];
        Player bestPlayer = new Player();
        
    	for (Team currTeam: theTeams) {
            thePlayers = currTeam.getPlayerArray();
            
            for (Player player: thePlayers)
            {
            	if (player.getGoalsScored() > bestPlayer.getGoalsScored())
            		bestPlayer = player;  
            }
            
            string += (currTeam.getTeamName() + "'s best player is " + bestPlayer.getPlayerName() + "\n");
        	bestPlayer = new Player();
    	}
    	
    	return string;
    }
}
