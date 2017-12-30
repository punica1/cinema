package cinema;

import java.io.*;
import java.util.*;

public class Report {
	
	public Report(){
		getMovies();	
	}
	
	/**
	 * get the names and time of movies shown in this day.
	 */
	public void getMovies(){
		try{
			FileReader seatfile = new FileReader("src/files/movies.txt");
			BufferedReader seatbuffer = new BufferedReader(seatfile);
			String seatinfo = seatbuffer.readLine();
			while (seatinfo != null){
				calcu(seatinfo);
				reset(seatinfo);
				seatinfo = seatbuffer.readLine();
			}
			seatbuffer.close(); 	seatfile.close();
			
		}
		catch(IOException e){
			System.out.println("Error while read movies.txt");
		}
	}
	
	/**
	 * for each movie calculate the total of its sales and the number of tickets sold
	 * @param movieName
	 */
	public void calcu(String movieName){
		int[] tickets = new int[4];
		
			try{
				FileReader moviefile = new FileReader("src/files/" + movieName + ".txt");
				BufferedReader moviebuffer = new BufferedReader(moviefile);
				String movieinfo = moviebuffer.readLine();
				String[] ticketType = new String[2];
				while (movieinfo != null){
					StringTokenizer myST = new StringTokenizer(movieinfo,",",false);
					
					for(int j = 0; myST.hasMoreTokens(); j++)	{
						ticketType[j] = myST.nextToken();
					}
					if(ticketType[0].equals("1"))		tickets[0]++;
					else if(ticketType[0].equals("2"))	tickets[1]++;
					else if(ticketType[0].equals("3"))	tickets[2]++;
					else if(ticketType[0].equals("4"))	tickets[3]++;
					
					movieinfo = moviebuffer.readLine();
				}
				moviebuffer.close(); 	moviefile.close();
				
			}
			catch(IOException e){
				System.out.println("Error while read movies.txt");
			}

			String content = movieName.substring(0,movieName.length()-2)+":"+movieName.substring(movieName.length()-2,movieName.length())
							+ "\r\n" + "Child Ticket: " + tickets[0] + "\r\n"
							+ "Adult Ticket: " + tickets[1] + "\r\n"
							+ "Senior Ticket: " + tickets[2] + "\r\n"
							+ "Student Ticket: " + tickets[3] + "\r\n"
							+"Total Number: " + (tickets[0]+tickets[1]+tickets[2]+tickets[3])+"\r\n"
							+"Total Sales: " + (8*tickets[0]+16*tickets[1]+12.8*tickets[2]+13.6*tickets[3])+"\r\n\r\n";
			try{
				FileWriter ticketFile = new FileWriter("src/files/" + Calendar.getInstance().get(Calendar.DATE)+".txt",true);
				BufferedWriter ticketbuffer = new BufferedWriter(ticketFile);
				ticketbuffer.write(content);			
				ticketbuffer.close(); 	ticketFile.close();
			}
			
			catch(IOException e){
				System.out.println("Error while write ticketFile");
			}
	}
	/**
	 * for each movie, reset the seat file for next day's use
	 * @param movieName 
	 */
	
	public void reset(String movieName){
			File moviefile = new File ("src/files/" + movieName + ".txt");
			 if((moviefile).exists())   moviefile.delete();
	}
	
}
