package cinema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 	*	A class ask users to buy tickets with selecting the ticket type and number.
 	*
 	*	@author      YUDU
 	*	@time		2017-5
 	*
 	*/
public class buyTicket{
	
	Ticket[] choice;
	String movie;
	String time;
	int screen;
	
	JFrame frame = new JFrame("Cinema Kiosk");
	Font fbutton= new Font("Cambria",Font.BOLD,20);
	Font flabel0 = new Font("Cambria",Font.BOLD,40);
	Font flabel1 = new Font("Cambria",Font.BOLD,34); 
	 
	
	public void buyTicket(String movie,String s){
		this.movie = movie;
		this.screen = Integer.parseInt(s.substring(6,7));
		this.time = s.substring(8,10) + s.substring(11);
		
		JComboBox combo[] = new JComboBox[5];
		JLabel label[] = new JLabel[5];
		JPanel panel[] = new JPanel[5];
		JButton button = new JButton();
		JButton button1 = new JButton();
		for(int i=0;i<5;i++){
			combo[i] = new JComboBox();
			label[i] = new JLabel();
			panel[i] = new JPanel();
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label[0].setFont(flabel0);
		label[0].setText("<html>"+"<br>Please choose the type and number of tickets:</html>");
		label[1].setFont(fbutton);
		label[1].setText("<html>  Child ticket for 2 to 17 years old:"+"<br>  Discount for 50%</html>");
		label[2].setFont(fbutton);
		label[2].setText("<html>  Adult ticket for 18 years and older:"+"<br>  No discount</html>");
		label[3].setFont(fbutton);
		label[3].setText("<html>  Senior ticket for 55 years and older:"+"<br>  Discount for 20%</html>");
		label[4].setFont(fbutton);
		label[4].setText("<html>  Student ticket for 18 years and older and in full time education:"+"<br>  Disount for 15%");
		for(int i=0;i<4;i++){
			combo[i].setFont(fbutton);
			combo[i].addItem("0");
			combo[i].addItem("1");
			combo[i].addItem("2");
			combo[i].addItem("3");
			combo[i].addItem("4");
		}
		
		button.setText("Confirm");
		button.setFont(fbutton);
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int child = combo[0].getSelectedIndex();
				int adult = combo[1].getSelectedIndex();
				int senior = combo[2].getSelectedIndex();
				int student = combo[3].getSelectedIndex();
				
				if( (child + adult + senior + student) > 5 ) tooManyTicket();
				else{
					choice = new Ticket[child + adult + senior + student];
					for (int i =0; i<child;i++){
						choice[i] = new Ticket(movie,time,1,screen);
					}
					for (int i =0; i<adult;i++){
						System.out.println(child);
						choice[i + child] = new Ticket(movie,time,2,screen);
					}
					for (int i =0; i<senior;i++){
						choice[i +child + adult] = new Ticket(movie,time,3,screen);
					}
					for (int i =0; i<student;i++){
						choice[i + child + adult + senior] = new Ticket(movie,time,4,screen);
					}
					System.out.println(choice.length);
					new Screen(choice,screen);
					frame.dispose();
				}
			}
		});
		
		button1.setFont(fbutton);
		button1.setText("Rechoose the film");
		button1.addActionListener(new reChoose());
		
		panel[0].add(label[0]);
		panel[2].add(button1);
		panel[2].add(button);
		panel[1].setLayout(new GridLayout(4,2));
		panel[1].add(label[1]);
		panel[1].add(combo[0]);
		panel[1].add(label[2]);
		panel[1].add(combo[1]);
		panel[1].add(label[3]);
		panel[1].add(combo[2]);
		panel[1].add(label[4]);
		panel[1].add(combo[3]);
		panel[1].setBorder(BorderFactory.createEmptyBorder(100, 0, 100, 0));
		frame.getContentPane().add(BorderLayout.NORTH, panel[0]);
		frame.getContentPane().add(BorderLayout.CENTER, panel[1]);
		frame.getContentPane().add(BorderLayout.SOUTH, panel[2]);
		frame.setSize(1300,800);
		frame.setVisible(true);
		

	}
	
	public void tooManyTicket(){
		JDialog tooMany = new JDialog(frame,"Too many tickets",true);
		
		JLabel show = new JLabel ("Too many tickets I cannot handle :(",JLabel.CENTER);
		show.setFont(fbutton);
		tooMany.add(show,BorderLayout.CENTER);
		
		JButton confirm = new JButton("OK");
		confirm.setFont(fbutton);
		//confirm.setBackground(c4);
		confirm.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new chooseFilm();
					frame.dispose();
					tooMany.dispose();
				}	
			});
		tooMany.add(confirm, BorderLayout.SOUTH);
		
		tooMany.setSize(400,300);
		tooMany.setBounds(300, 200,400,300);
		tooMany.setVisible(true);
		tooMany.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		tooMany.dispose();

		frame.dispose();
	}
	
	class reChoose implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new chooseFilm();
		}
	}
	
	
}

