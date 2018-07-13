/* Author: Fady Tarek Selim
 * Developer? Insert your name here:
 * 1- 
 * */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class Main {

	private JFrame frmLeagueHighlights;
	private JTable table;
	private JTextPane txtpnTheBestPlayer;

	static League theLeague = new League();
    static String teamNames = "Real Madrid,Barcelona,Atletico";
    static int teamSize = 5;
 
    static Team[] theTeams = theLeague.createTeams(teamNames, teamSize);
    public static Game[] theGames = theLeague.createGames(theTeams);
    
	public static void main(String[] args) {
	        try {
	            
	            for (Game currGame : theGames) {
	                currGame.playGame();
	                System.out.println(currGame.getDescription(true));
	            }

	            theLeague.setTeamStats(theTeams, theGames);
	            theLeague.setPlayerStats(theGames);
	            
	            theLeague.showBestTeam(theTeams);

	        } catch (Exception e) {
	            e.printStackTrace(System.err);
	        }
	        
	    // GUI is optimized for 3 Teams only    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmLeagueHighlights.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	public void initialize() {
		frmLeagueHighlights = new JFrame();
		frmLeagueHighlights.setTitle("League Highlights\r\n");
		frmLeagueHighlights.setBounds(100, 100, 470, 266);
		frmLeagueHighlights.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(0, 78, 444, 64);
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Ranking", "Team Name", "Points Gained", "Goals Scored"},
				{1, theTeams[0].getTeamName(), theTeams[0].getPointsTotal(), theTeams[0].getGoalsTotal()},
				{2, theTeams[1].getTeamName(), theTeams[1].getPointsTotal(), theTeams[1].getGoalsTotal()},
				{3, theTeams[2].getTeamName(), theTeams[2].getPointsTotal(), theTeams[2].getGoalsTotal()},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Integer.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMinWidth(16);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(21);
		table.getColumnModel().getColumn(3).setMaxWidth(60);
		frmLeagueHighlights.getContentPane().setLayout(null);
		frmLeagueHighlights.getContentPane().add(table);
		
		JTextPane txtpnTheWinnerOf = new JTextPane();
		txtpnTheWinnerOf.setEditable(false);
		txtpnTheWinnerOf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		txtpnTheWinnerOf.setText("The winner of the league is " + theTeams[0]);
		txtpnTheWinnerOf.setBounds(0, 0, 444, 30);
		frmLeagueHighlights.getContentPane().add(txtpnTheWinnerOf);
		
		txtpnTheBestPlayer = new JTextPane();
		txtpnTheBestPlayer.setEditable(false);
		txtpnTheBestPlayer.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		txtpnTheBestPlayer.setText("The Best player of the league is " + theLeague.showBestPlayerByLeague(theTeams, teamSize));
		
		txtpnTheBestPlayer.setBounds(0, 41, 444, 30);
		frmLeagueHighlights.getContentPane().add(txtpnTheBestPlayer);
		
		JTextPane txtpnBuffer = new JTextPane();
		txtpnBuffer.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		txtpnBuffer.setText(theLeague.showBestPlayerByTeam(theTeams, teamSize));
		txtpnBuffer.setBounds(0, 153, 444, 73);
		
		frmLeagueHighlights.getContentPane().add(txtpnBuffer);
	}
}
