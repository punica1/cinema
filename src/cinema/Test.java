package cinema;

import java.util.Calendar;
import java.io.*;

public class Test {

	public static void main(String[] args){
		
		if( Calendar.getInstance().get(Calendar.HOUR)==0){
			if(!(new File("src/files/" + Calendar.getInstance().get(Calendar.DATE)+".txt")).exists())
			new Report();
		}
			
		Welcome a =new Welcome();
		/*
		Ticket[] c = new Ticket[2];
		c[0] = new Ticket("BEAUTY AND THE BEAST","1000",2,2);
		c[1] = new Ticket("BEAUTY AND THE BEAST","1000",2,2);
		c[0].ID = "1122";
		c[1].ID = "1222";
		Screen a = new Screen(c,2);
		*/
		/*
		Ticket b = new Ticket("1","1",1,1);
		b.seat = 3;
		System.out.println(b.getID());
		*/
		
			}
}
