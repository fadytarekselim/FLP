import java.util.*;
public class PlayerDatabase {
    
    private ArrayList <Player> players;
    
    public PlayerDatabase(){
        StringTokenizer playersST = new StringTokenizer(playersList, ",");
        players = new ArrayList<Player>();
        while (playersST.hasMoreTokens()){
            players.add(new Player(playersST.nextToken()));
        }
    }
    
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
    
    
        
String playersList = 
"Aaron Filler," + 
"Alan Patton," +
"Alexander Solzhenitsyn," +
"Arthur Conan Doyle," +
"Anthony Trollope," +
"Baroness Orczy," +          
"Brendan Behan," +      
"Brian Moore," +
"Boris Pasternak," +
"Charles Dickens," +    
"Charlotte Bronte," +
"Dorothy Parker," +
"Emile Zola," +
"Frank O'Connor," +        
"Geoffrey Chaucer," +
"George Eliot," +
"G. K. Chesterton," +
"Graham Green," +
"Henry James," +
"James Joyce," +        
"J. M. Synge," + 
"J. R. Tolkien," +
"Jane Austin," +
"Leo Tolstoy," +
"Liam O'Flaherty," +
"Marcel Proust," +
"Mark Twain," +
"Oscar Wilde," +
"O. Henry," +
"Samuel Beckett," +
"Sean O'Casey," +
"William Shakespeare," +        
"William Makepeace Thackeray," +
"W. B. Yeats," +
"Wilkie Collins";
    
}
