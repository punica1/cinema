package cinema;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Screen implements ActionListener{

	int ticketNumber;
	int screentype;
	int seatcolumn;
	Ticket[] choice;
	
	JFrame frame;
	JButton[] seats;
	Font f1 = new Font("Arial",Font.CENTER_BASELINE,20);
	Font f2 = new Font("Cambria",Font.BOLD,32);
	Font f3 = new Font("Arial",Font.CENTER_BASELINE,15);
	Color c1 = new Color(140,140,140);
	Color c2 = new Color(189,189,189);
	Color c3 = new Color(219,94,94);
	Color c4 = new Color(119,189,125);
	ImageIcon icon = new ImageIcon("src/pictures/image.png");
	
	/**
	 * this class is to give user a UI to choose seats.
	 * 
	 * @author      Yizhi Zhang
	 * @time		2017-4
	 * 
	 * @param choice
	 * @param screentype
	 */
	public Screen(Ticket[] choice,int screentype){
		this.choice = choice;
		this.screentype = screentype;
		this.ticketNumber = choice.length;
		System.out.println(ticketNumber);
		
		if(screentype==1){
			seats = new JButton[32];
			seatcolumn = 4;
		}
		else if(screentype==2){
			seats = new JButton[26];
			seatcolumn = 4;
		}
		else if(screentype==3){
			seats = new JButton[32];
			seatcolumn = 5;
		}
		draw();
	}
	
	
	/**
	 * for different screen type, draw a friendly UI for each screen to let user choice their seats.
	 */
	public void draw(){
		frame = new JFrame("Select Seats");
		
		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		JLabel text = new JLabel("Please click the seat(s) you want to choose:",JLabel.CENTER);
		text.setFont(f2);
		north.add(text,BorderLayout.CENTER);
		north.add(new JLabel("    "),BorderLayout.SOUTH);
		frame.add(north,BorderLayout.NORTH);
		//frame.add(new JLabel("        "),BorderLayout.NORTH);
		
		JPanel south = new JPanel();
		south.setLayout(new BorderLayout());
		JLabel screen = new JLabel("SCREEN",JLabel.CENTER);
		screen.setFont(f1);
		screen.setBackground(c1);
		screen.setOpaque(true);	
		south.add(new JLabel("    "),BorderLayout.NORTH);
		south.add(screen,BorderLayout.SOUTH);
		frame.add(south, BorderLayout.SOUTH);
		
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(seatcolumn,1));
		for(int i=seatcolumn-1; i>=0;i--){
			JLabel a = new JLabel("     "+(char)(65+i)+"     ");
			a.setFont(f3);
			left.add(a);
		}
		frame.add(left, BorderLayout.WEST);
		
		JPanel right = new JPanel();
		right.setLayout(new GridLayout(seatcolumn,1));
		for(int i=seatcolumn-1; i>=0;i--){
			JLabel a = new JLabel("     "+(char)(65+i)+"     ");
			a.setFont(f3);
			right.add(a);
		}
		frame.add(right, BorderLayout.EAST);
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(seatcolumn,9));
		if(screentype == 1){			
			for (int i=0; i<seats.length;i++){
				seats[i] = new JButton("" + (8-i%8));
				seats[i].setIcon(icon);
				seats[i].setBackground(c2);
				seats[i].setVerticalTextPosition(SwingConstants.BOTTOM);
				seats[i].setHorizontalTextPosition(SwingConstants.CENTER);
				seats[i].setBorderPainted(false);
				seats[i].setFont(f3);
				seats[i].addActionListener(this);
				if( i%8==3){
					center.add(seats[i]);
					center.add(new JLabel("       "));
				}
				else	center.add(seats[i]);
			}
		}
		else if(screentype==2){
			for (int i=0; i<8;i++){
				seats[i] = new JButton("" + (8-i%8));
				seats[i].setIcon(icon);
				seats[i].setBackground(c2);
				seats[i].setVerticalTextPosition(SwingConstants.BOTTOM);
				seats[i].setHorizontalTextPosition(SwingConstants.CENTER);
				seats[i].setBorderPainted(false);
				seats[i].setFont(f3);
				seats[i].addActionListener(this);
				if( i%8==3){
					center.add(seats[i]);
					center.add(new JLabel("       "));
				}
				else	center.add(seats[i]);
			}
			for (int i=8; i<seats.length;i++){
				seats[i] = new JButton("" + (6-(i-2)%6));
				seats[i].setIcon(icon);
				seats[i].setBackground(c2);
				seats[i].setVerticalTextPosition(SwingConstants.BOTTOM);
				seats[i].setHorizontalTextPosition(SwingConstants.CENTER);
				seats[i].setBorderPainted(false);
				seats[i].addActionListener(this);
				seats[i].setFont(f3);
				if( i%6==2 || i%6==5 ){
					center.add(new JLabel("       "));
					center.add(seats[i]);
				}
				else if ( i%6==1){
					center.add(seats[i]);
					center.add(new JLabel("       "));
				}
				else	center.add(seats[i]);
			}
			
			
		}
		else if(screentype == 3){			
			for (int i=0; i<8;i++){
				seats[i] = new JButton("" + (8-i%8));
				seats[i].setIcon(icon);
				seats[i].setBackground(c2);
				seats[i].setVerticalTextPosition(SwingConstants.BOTTOM);
				seats[i].setHorizontalTextPosition(SwingConstants.CENTER);
				seats[i].setBorderPainted(false);
				seats[i].setFont(f3);
				seats[i].addActionListener(this);
				center.add(seats[i]);
			}
			for (int i=8; i<seats.length;i++){
				seats[i] = new JButton("" + (6-(i-8)%6));
				seats[i].setIcon(icon);
				seats[i].setBackground(c2);
				seats[i].setVerticalTextPosition(SwingConstants.BOTTOM);
				seats[i].setHorizontalTextPosition(SwingConstants.CENTER);
				seats[i].setBorderPainted(false);
				seats[i].setFont(f3);
				seats[i].addActionListener(this);
				if(i%6==3 || i%6==5){
					center.add(seats[i]);
					center.add(new JLabel("    "));
				}
				else	center.add(seats[i]);
			}
		}
		check();
		frame.add(center, BorderLayout.CENTER);
		
		frame.setSize(800,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed (ActionEvent e){
		for(int i=0;i<seats.length;i++){
			if((e.getSource())== seats[i]){
				
				if(ticketNumber==0)	{
					new Confirm(choice);
					frame.dispose();
				}
				
				seats[i].setBackground(c4);
					choice[ticketNumber-1].seat = i;
					System.out.println(ticketNumber);
					ticketNumber--;
					if(ticketNumber==0)	{
						new Confirm(choice);
						frame.dispose();
					}
			}
		}
	}
	
	/**
	 * before user's choosing the seats, list the seats sold out and mark them red, unenabled.
	 */
	public void check(){
		String a = "" +choice[0].movie + "," + choice[0].time + ".txt";
		try{
			FileReader seatfile = new FileReader("src/files/"+a);
			BufferedReader seatbuffer = new BufferedReader(seatfile);
			String seatinfo = seatbuffer.readLine();
			
			String[] temp = new String[2]; // to store the stringTokenizer
			
			while (seatinfo != null){
				StringTokenizer myST = new StringTokenizer(seatinfo,",",false);
				
				for(int j = 0; myST.hasMoreTokens(); j++)	{
					temp[j] = myST.nextToken();
					//System.out.println(j);
				}
				seats[Integer.parseInt(temp[1])].setBackground(c3);
				seats[Integer.parseInt(temp[1])].setEnabled(false);
				
				seatinfo = seatbuffer.readLine();
			}
			seatbuffer.close(); 	seatfile.close();
			
		}
		catch(IOException e){
			System.out.println("Error while read " + a);
		}
	}
	
}
