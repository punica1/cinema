package cinema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 	*	A class to remind kinds of errors.
 	*
 	*	@author      YUDU
 	*	@time		2017-5
 	*
 	*/
public class Error implements ActionListener{
	
	int movie;
	
	JFrame frame = new JFrame("Error!");
	Font fbutton= new Font("Cambria",Font.BOLD,20);
	Font flabel = new Font("Cambria",Font.BOLD,28);
	
	 /**
	   * Choosing unavailable time
	   * 
	   */
	public Error(int movie){
		this.movie = movie;
	}
	public void timeErr(){
	JButton button = new JButton();
	JLabel label = new JLabel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	label.setFont(fbutton);
	label.setText("Sorry, you have already passed that time.");
	button.setText("OK");
	button.setFont(fbutton);
	button.addActionListener(this);
	
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	panel1.add(label);
	panel2.add(button);
	panel1.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
	frame.getContentPane().add(BorderLayout.CENTER, panel1);
	frame.getContentPane().add(BorderLayout.SOUTH, panel2);
	frame.setSize(450,200);
	frame.setLocation(screenWidth/2, screenHeight/2);
	frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		if(movie==1)	new KONG();
		else if(movie==2)	new LALA();
		else if(movie==3)	new LOGAN();
		else if(movie==4)	new MOON();
		else if(movie==5)	new BEAUTY();
	}
}
