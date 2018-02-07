package commandline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class DataBaseCon
{

	private static Connection connection =null;
	
	//input gameinfo to database
	public static void inputGameInfo(int rounds, int draws, ArrayList<Player> players, String winner){
		
		System.err.println("DATABASE CALLED");
		connect();
		Statement stmt = null;
		
		int playerWins = players.get(0).getRoundsWon();
		int ai1Wins = players.get(1).getRoundsWon();
		
		String ai2wins = "NULL";
		String ai3wins = "NULL";
		String ai4wins = "NULL";
		
		if(players.size() > 2)
			ai2wins = Integer.toString(players.get(2).getRoundsWon());
		if(players.size() > 3)
			ai3wins = Integer.toString(players.get(3).getRoundsWon());
		if(players.size() > 4)
			ai4wins = Integer.toString(players.get(4).getRoundsWon());
		
		String query = String.format("INSERT INTO toptrumps.gamedata (gamewinner, numberrounds, humanroundwins, ai1wins, ai2wins, ai3wins, ai4wins, numberdraws) "
				+ "VALUES ('%s', %d, %d, %d, %s, %s, %s, %d)", winner, rounds, playerWins, ai1Wins, ai2wins, ai3wins, ai4wins, draws);
		
//		String query = "INSERT into toptrumps.gamedata (gamewinner, numberrounds, humanroundwins, ai1wins,ai2wins,ai3wins,ai4wins)"
//				+ "Values('"+winName+"', "+countRounds+", "+roundWins[0]+", "+roundWins[1]+", "+roundWins[2]+", "+roundWins[3]+", "+roundWins[4]+");";
		try 
		{
			stmt = connection.createStatement();
			 stmt.executeUpdate(query);

		}
		catch (SQLException e )
		{
			e.printStackTrace();
			System.err.println("error executing query " + query);
		}
				
		close();
		//System.out.print(winName + countRounds + Arrays.toString(roundWins));
	}
	//connect
	public static void connect()
	{
		String dbname ="m_17_1102401d";
		String username = "m_17_1102401d";
		String password = "1102401d";
		
		try 
		{
			connection =
					DriverManager.getConnection("jdbc:postgresql://yacata.dcs.gla.ac.uk:5432/" + 
							dbname,username, password);
		}
		catch (SQLException e) 
		{
			System.err.println("Connection Failed!");
			e.printStackTrace();
			return;
		}
		if (connection != null)
		{
			System.out.println("Connection successful");
		}
		else 
		{
			System.err.println("Failed to make connection!");
		}
	}

	//method to close connection
		public static void close()
		{
			try 
			{
				connection.close();
				System.out.println("Connection closed");
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Connection could not be closed – SQL exception");
			}
		}
		
		//method that returns number of games played
		public static int numGames()
		{
			
			int gamesPlayed = 0;
			Statement stmt = null;
			String query = "SELECT COUNT (gamenumber) FROM toptrumps.gamedata;";
			try 
			{
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				//the next method of ResultSet allows you to iterate through the results
				if (rs.next())
				{
					//count the number enrolled in a class
					gamesPlayed =rs.getInt("count");				
				}

			}
			catch (SQLException e )
			{
				e.printStackTrace();
				System.err.println("error executing query " + query);
			}
			//System.out.println("Games: "+gamesPlayed);
			
			return gamesPlayed;
		}
		
		//method that returns number of times human has won
		public static int humanWins()
		{
			
			int wins = 0;
			Statement stmt = null;
			String query = "SELECT COUNT(gamenumber) FROM toptrumps.gamedata WHERE gamewinner = 'human';";
			try 
			{
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				//the next method of ResultSet allows you to iterate through the results
				if (rs.next())
				{
					//count the number enrolled in a class
					wins =rs.getInt("count");				
				}

			}
			catch (SQLException e )
			{
				e.printStackTrace();
				System.err.println("error executing query " + query);
			}
			//System.out.println("human wins: "+wins);
			
			return wins;
		}
		
		//method that returns number of ai wins
		public static int aiWins()
		{
			
			int wins = 0;
			Statement stmt = null;
			String query = "SELECT COUNT(gamenumber) FROM toptrumps.gamedata WHERE gamewinner = 'AI Player 1' "
					+ "OR gamewinner = 'AI Player 2' OR gamewinner = 'AI Player 3' OR gamewinner = 'AI Player 4';";
			try 
			{
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				//the next method of ResultSet allows you to iterate through the results
				if (rs.next())
				{
					//count the number enrolled in a class
					wins =rs.getInt("count");				
				}

			}
			catch (SQLException e )
			{
				e.printStackTrace();
				System.err.println("error executing query " + query);
			}
			//System.out.println("ai wins: "+wins);
			
			return wins;
		}
		
		//method to return average number of  draws in a round
		public static double avgDraws()
		{
			
			double avg=0.0;
			Statement stmt = null;
			String query = "SELECT AVG(numberdraws) FROM toptrumps.gamedata;";
			try 
			{
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				//the next method of ResultSet allows you to iterate through the results
				if (rs.next())
				{
					//count the number enrolled in a class
					avg =rs.getDouble("avg");				
				}

			}
			catch (SQLException e )
			{
				e.printStackTrace();
				System.err.println("error executing query " + query);
			}
			//System.out.println("avg draws: " +avg);
			
			return avg;
					
		}
		
		
		//method that returns max rounds in a game
		public static int maxRounds()
		{
			
			int max = 0;
			Statement stmt = null;
			String query = "SELECT MAX(numberrounds) FROM toptrumps.gamedata;";
			try 
			{
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);

				//the next method of ResultSet allows you to iterate through the results
				if (rs.next())
				{
					//count the number enrolled in a class
					max =rs.getInt("max");				
				}

			}
			catch (SQLException e )
			{
				e.printStackTrace();
				System.err.println("error executing query " + query);
			}
			//System.out.println("max draws: "+max);
			
			return max;
		}
		
}