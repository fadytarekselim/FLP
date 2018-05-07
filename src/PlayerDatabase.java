import java.util.*;
public class PlayerDatabase {
    // Declarations
    private ArrayList <Player> players;
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
    		"Elba Elma" +    
    		"Fady Tarek," +
    		"Fareh waryaa," +
    		"Fozi Ali," +
    		"Ghazi Gomez,";
    
    // Inputting the players to the ArrayList to be easily accessed
    public PlayerDatabase(){
        StringTokenizer playersST = new StringTokenizer(playersList, ",");
        players = new ArrayList<Player>();
        while (playersST.hasMoreTokens()){
            players.add(new Player(playersST.nextToken()));
        }
    }
    
    // Distributing some of the players in the database to create a team
    public Player[] getTeam(int numberOfPlayers) throws Exception {
        Player[] teamPlayers = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++){
            int playerIndex = (int) (Math.random() * players.size());
            
            try {
            			teamPlayers[i] = players.get(playerIndex);
            			players.remove(playerIndex);
            }
            catch(IndexOutOfBoundsException ie){
            			throw new Exception("Not enough players in the database for the teams requested.");
            }
            
        }
        
        return teamPlayers;  
    }
}
