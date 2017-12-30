package cinema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * this class is to give the user tickets and let them psy for the tickets
 * @author Yizhi Zhang
 *
 */
public class GiveTickets {

	public GiveTickets(Ticket[] choice,String[] seat){
		String seatinfo = "";
		for(int i=0; i< choice.length;i++){
			seatinfo += choice[i].ticketType + "," + choice[i].seat+"\r\n";
			
			
			String content = "Ticket ID:" +choice[i].getID() + "\r\n" + choice[i].movie + "  "  +choice[0].time.substring(0,2)+":" +choice[0].time.substring(2,4)
					+"\r\nSeat: Screen" + choice[i].screen + "  " + seat[i] +"\r\n";
			if(choice[i].ticketType==1)	content += "Child Ticket";
			else if(choice[i].ticketType==2)	content += "Adult Ticket";
			else if(choice[i].ticketType==3)	content += "Senior Ticket";
			else 	content += "Student Ticket";
			
					
			try{
				FileWriter ticketFile = new FileWriter("src/files/" + choice[i].ID+".txt");
				BufferedWriter ticketbuffer = new BufferedWriter(ticketFile);
				ticketbuffer.write(content);			
				ticketbuffer.close(); 	ticketFile.close();
			}
			
			catch(IOException e){
				System.out.println("Error while write ticketFile");
			}
		}
		
		try{
			FileWriter ticketFile = new FileWriter("src/files/" + choice[0].movie+","+choice[0].time+".txt",true);
			BufferedWriter ticketbuffer = new BufferedWriter(ticketFile);
			ticketbuffer.write(seatinfo);			
			ticketbuffer.close(); 	ticketFile.close();
		}
		
		catch(IOException e){
			System.out.println("Error while write ticketFile");
		}
	}
}
