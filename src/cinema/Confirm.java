package cinema;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Confirm {
	Ticket[] choice;
	String[] seats;
	
	JFrame frame;
	Font f1 = new Font("Arial",Font.BOLD,24);
	Font f2 = new Font("Cambria",Font.BOLD,32);
	Font f3 = new Font("Cambria",Font.BOLD,20);
	Color c1 = new Color(140,140,140);
	Color c2 = new Color(189,189,189);
	Color c3 = new Color(219,94,94);
	Color c4 = new Color(119,189,125);
	
	/**
	 * this class is to let user confirm their choice
	 *
	 *	@author      Yizhi Zhang
	 *	@time		2017-4
	 *
	 */
	public Confirm(Ticket[] choice){
		this.choice = choice;
		makeconfirm();
		
	}
	
	/**
	 * give user a confirm UI to let user to confirm their movie and seat info, then they can pay or go back.
	 */
	public void makeconfirm(){
		frame = new JFrame();
		
		JLabel text = new JLabel("Please confirm the information:",JLabel.CENTER);
		text.setFont(f2);
		frame.add(text,BorderLayout.NORTH);
		frame.add(new JLabel("   "),BorderLayout.WEST);
		frame.add(new JLabel("   "),BorderLayout.EAST);
		
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(4,1));
		
		JLabel movie = new JLabel("" + choice[0].movie + "  " + choice[0].time.substring(0,2)+":" +choice[0].time.substring(2,4));
		movie.setFont(f1);
		info.add(movie);
		
		String a = "Screen " + choice[0].screen + "    Seat: ";
		seats = new String[choice.length];
		
		for (int i=0; i<choice.length;i++){
			if(choice[0].screen == 1){
				seats[i] = (char) ( 65 + 3 - ((int)choice[i].seat/8)) + (8 - choice[i].seat % 8 + "  ");
				a += seats[i];
			}
			else if(choice[0].screen == 2){
				if(choice[i].seat < 8)	{
					seats[i]= "D" + (8 - choice[i].seat)+ "  ";
					a += seats[i];
				}
				else {
					seats[i] = (char) ( 65 + 2 - ((int)(choice[i].seat-8)/6))+( 6 - (choice[i].seat-8) % 6 + "  " );
					a += seats[i];
				}
			}
			else{
				if(choice[i].seat < 8)	{
					seats[i] =  "E" + (8 - choice[i].seat)+ "  ";
					a +=seats[i];
				}
				else{
					seats[i]= (char) ( 65 + 3 - ((int)(choice[i].seat-8)/6)) +(6 - (choice[i].seat-8) % 6 + "  ");
					a += seats[i];
				}
			}
		}
		JLabel seat = new JLabel(a);
		seat.setFont(f1);
		info.add(seat);
		
		String b = "";
		double totalprice = 0;
		for (int i=0; i<choice.length;i++){
			totalprice += choice[i].price;
			if (choice[i].ticketType == 1)	 b+= "Child Ticket: 1   ";
			else if (choice[i].ticketType == 2)	 b+= "Adult Ticket: 1   ";
			else if (choice[i].ticketType == 3)	 b+= "Senior Ticket: 1   ";
			else  b+= "Student Ticket: 1   ";
		}
				
		JLabel ticket = new JLabel(b);
		ticket.setFont(f1);
		info.add(ticket);
		
		JLabel price = new JLabel("You need to pay: " + totalprice);
		price.setFont(f1);
		info.add(price);
		
		
		JPanel southpanel = new JPanel();
		southpanel.setLayout(new GridLayout(1,2));
		JButton back = new JButton("Go Back");
		back.setFont(f3);
		back.setBackground(c3);
		back.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							new chooseFilm();
							frame.dispose();
						}
						
						});
		southpanel.add(back);
		
		JButton confirm = new JButton("Confirm");
		confirm.setFont(f3);
		confirm.setBackground(c4);
		southpanel.add(confirm);
		confirm.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							new GiveTickets(choice,seats);
							
							JDialog right = new JDialog(frame,"Sucess!",true);
							
							JLabel show = new JLabel ("Please take your Ticket(s)",JLabel.CENTER);
							show.setFont(f3);
							right.add(show,BorderLayout.CENTER);
							
							JButton confirm = new JButton("OK");
							confirm.setFont(f3);
							confirm.setBackground(c4);
							confirm.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										new Welcome();
										frame.dispose();
										right.dispose();
									}	
								});
							right.add(confirm, BorderLayout.SOUTH);
							
							right.setSize(400,300);
							right.setBounds(300, 200,400,300);
							right.setVisible(true);
							right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

							right.dispose();

							frame.dispose();
						}	
					});
		frame.add(southpanel, BorderLayout.SOUTH);
		
		frame.add(info, BorderLayout.CENTER);
		frame.setSize(1000,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
