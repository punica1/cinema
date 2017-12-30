package cinema;

public class Ticket {
	String movie;    
	String time;
	int ticketType;
	int screen;
	String ID;
	int seat;
	double price;
	
	public Ticket(String movie,String time,int ticketType,int screen){
		this.movie = movie;
		this.time = time;
		this.ticketType = ticketType;
		this.screen = screen;
		
		if(ticketType == 1){
			this.price =8 ;
		}
		else if(ticketType == 2){
			this.price =16 ;
		}
		else if(ticketType == 3){
			this.price = 12.8;
		}
		else if(ticketType == 4){
			this.price =13.6 ;
		}
	}
	public String getID(){
		int module16 = (int) seat / 16 ;
		int module4 =(int) (this.seat - module16*16)/4;
		int module1 = (int) (this.seat- module16*16 -module4*4 );
		
		this.ID = this.screen +""+  this.ticketType+ ""+
				module16 + "" 
				+ module4 + "" + module1 + "" + "111";
		//System.out.println(module16);
		return ID;
		
	}
}
