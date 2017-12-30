package cinema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

/**
 	*	Showing the arranged time and screen for films, and ask users to choose from one of the choices.
 	*	Film MOONLIGHT
 	*
 	*	@author      YUDU
 	*	@time		2017-4
 	*
 	*/
public class MOON implements ActionListener{
	JFrame frame = new JFrame("Cinema Kiosk");
	
	 /**
	   * Choosing Time & Screen User Interface
	   * 
	   */
	public MOON(){
		Font fbutton1= new Font("Cambria",Font.BOLD,20);
		Font fbutton2 = new Font("Arial",Font.PLAIN,26);
		Font flabel = new Font("Cambria",Font.BOLD,40);
		Color color = new Color(116,162,192);
		Color color2 = new Color(191,190,189);
		
		JPanel panel[] = new JPanel[10];
		JButton button[] = new JButton[10];
		JLabel label[] = new JLabel[10];
		for(int i=0;i<10;i++){
			panel[i] = new JPanel();
			button[i] = new JButton();
			label[i] = new JLabel();
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label[0].setText("<html>"+"<br>Please select an available time to watch MOONLIGHT:</html>");
		label[0].setFont(flabel);
		
		button[0].setFont(fbutton1);
		button[0].setText("Rechoose the film");
		button[0].addActionListener(new reChoose());
		
		button[1].setText("");
		button[1].setBackground(color2);
		button[2].setText("");
		button[2].setBackground(color2);
		button[3].setText("");
		button[3].setBackground(color2);
		button[4].setText("Screen2 16:00");
		button[4].setBackground(color);
		button[4].addActionListener(this);
		button[5].setText("Screen2 18:00");
		button[5].setBackground(color);
		button[5].addActionListener(this);
		button[6].setText("");
		button[6].setBackground(color2);
		button[7].setText("");
		button[7].setBackground(color2);
		button[8].setText("");
		button[8].setBackground(color2);
		button[9].setText("");
		button[9].setBackground(color2);
		
		panel[0].add(button[0]);
		panel[1].add(label[0]);
		panel[2].setLayout(new GridLayout(3,3));
		for(int i=1;i<10;i++){
			button[i].setFont(fbutton2);
			panel[2].add(button[i]);
		}
		panel[2].setBorder(BorderFactory.createEmptyBorder(100,0,100,0));
		
		frame.getContentPane().add(BorderLayout.SOUTH, panel[0]);
		frame.getContentPane().add(BorderLayout.NORTH, panel[1]);
		frame.getContentPane().add(BorderLayout.CENTER, panel[2]);
		frame.setSize(1300,800);
		frame.setVisible(true);
	}

	class reChoose implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new chooseFilm();
		}		
	}
	
	 /**
	   * Judging time method
	   * Users cannot choose the film that performs after current time
	   * 
	   */
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = ((JButton) (e.getSource())).getText();
		char a = s.charAt(8);
		char b = s.charAt(9);
		char c = s.charAt(11);
		char d = s.charAt(12);
		
		int an = Character.getNumericValue(a);
		int bn = Character.getNumericValue(b);
		int cn = Character.getNumericValue(c);
		int dn = Character.getNumericValue(d);
		
		int t = 1000*an+100*bn+10*cn+1*dn;
		
        Calendar now = Calendar.getInstance();   
        int hour = now.get(Calendar.HOUR_OF_DAY);  
        int minute = now.get(Calendar.MINUTE);
        int tN = hour * 100 + minute;
        
        if(tN<t){
        	frame.dispose();
        	new buyTicket().buyTicket("MOONLIGHT",s);
        }else{
        	frame.dispose();
        	new Error(4).timeErr();
        }
	}
}
