package cinema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
	*	A class to present the welcome interface.
	*
	*	@author      YUDU
	*	@time		2017-4
	*
	*/
public class Welcome implements ActionListener{
	JFrame frame = new JFrame("Cinema Kiosk");

	 /**
	   * Welcome User Interface
	   * 
	   */
	public Welcome(){
		Font fbutton= new Font("Cambria",Font.BOLD,20);
		Font flabel = new Font("Cambria",Font.BOLD,44);
		
		JButton button1 = new JButton();
		JPanel panel[] = new JPanel[2];
		panel[0] = new JPanel();
		panel[1] = new JPanel();
		JLabel label[] = new JLabel[2];
		label[0] = new JLabel();
		label[1] = new JLabel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button1.setFont(fbutton);
		button1.setText("Click to choose films");
		button1.addActionListener(this);
		
		label[0].setText("Welcome to our cinema!");
		label[0].setFont(flabel);
		label[1].setText("This system will help you to buy film tickets.");
		label[1].setFont(flabel);
		
		panel[0].add(button1);
		panel[1].add(label[0]);
		panel[1].add(label[1]);
		panel[1].setBorder(BorderFactory.createEmptyBorder(290, 100, 400, 100));
		
		frame.getContentPane().add(BorderLayout.SOUTH, panel[0]);
		frame.getContentPane().add(BorderLayout.CENTER, panel[1]);
		frame.setSize(1300,800);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new chooseFilm();
	}
	
	 /**
	   * Main Method
	   * 
	   */
	public static void main(String[] args){
		new Welcome();
	}
}
