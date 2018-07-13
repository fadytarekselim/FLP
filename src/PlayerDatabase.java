/* Author: Fady Tarek Selim
 * Developer? Insert your name here:
 * 1- 
 * */

import java.util.*;
public class PlayerDatabase {
	String playersList = 
    		"Ahmed Hassan," + 
    		"Asensio," +
    		"Busquets," +
    		"Casemiro," +
    		"Casillas," +
    		"Countino," +          
    		"Daryl York," +      
    		"Dida," +
    		"Emeric Abrignani," +
    		"Elba Elma," +    
    		"Fady Tarek," +
    		"Fareh waryaa," +
    		"Fozi Ali," +
    		"Ghazi Gomez," +
    		"Hamit Altintop";
    private ArrayList <Player> players;
    
    public PlayerDatabase(){
        StringTokenizer playersST = new StringTokenizer(playersList, ",");
        players = new ArrayList<Player>();
        while (playersST.hasMoreTokens()){
            players.add(new Player(playersST.nextToken()));
        }
    }
    
    public Player[] getTeam(int numberOfPlayers) {
        Player[] teamPlayers = new Player[numberOfPlayers];
        
        for (int i = 0; i < numberOfPlayers; i++){
            int playerIndex = (int) (Math.random() * players.size());
            
            try {
            teamPlayers[i] = players.get(playerIndex);
            players.remove(playerIndex);
            }
            catch(IndexOutOfBoundsException ie){
            	ie.printStackTrace(System.err);
            }
        }
        
        return teamPlayers;   
    }  
}
