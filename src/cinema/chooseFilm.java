package cinema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 	*	A class to ask users to choose one of the films.
 	*
 	*	@author      YUDU
 	*	@time		2017-4
 	*
 	*/
public class chooseFilm{
	JFrame frame=new JFrame("Select film");

	 /**
	   * Choosing Film User Interface
	   * 
	   */
	public chooseFilm(){
		Font fbutton = new Font("Cambria",Font.BOLD,19);
		Font flabel = new Font("Cambria",Font.BOLD,40);
		JPanel panel[] = new JPanel[10];
		JLabel label[] = new JLabel[10];
		JButton button[] = new JButton[10];
		for(int i=0;i<10;i++){
			panel[i] = new JPanel();
			button[i] = new JButton();
			label[i] = new JLabel();
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon img1 = new ImageIcon("src/posters/King Kong.png");
		ImageIcon img2 = new ImageIcon("src/posters/LOGAN.jpeg");
		ImageIcon img3 = new ImageIcon("src/posters/Beauty and The Beast.png");
		ImageIcon img4 = new ImageIcon("src/posters/MOONLIGHT.png");
		ImageIcon img5 = new ImageIcon("src/posters/LALA LAND.png");
		label[0].setIcon(img1);
		label[1].setIcon(img2);
		label[2].setIcon(img3);
		label[3].setIcon(img4);
		label[4].setIcon(img5);
		
		label[5].setText("<html>"+"<br>Please select one of the films by clicking the buttons at bottom:</html>");
		label[5].setFont(flabel);
		
		button[0].setText("<html>KONG: SKULL ISLAND"+"<br>118min</html>");
		button[0].addActionListener(new chooseKONG());
		button[1].setText("<html>LOGAN"+"<br>135min</html>");
		button[1].addActionListener(new chooseLOGAN());
		button[2].setText("<html>BEAUTY AND THE BEAST"+"<br>130min</html>");
		button[2].addActionListener(new chooseBEAUTY());
		button[3].setText("<html>MOONLIGHT"+"<br>111min</html>");
		button[3].addActionListener(new chooseMOON());
		button[4].setText("<html>LA LA LAND"+"<br>128min</html>");
		button[4].addActionListener(new chooseLALA());
		for(int i=0;i<5;i++){
			button[i].setHorizontalAlignment(SwingConstants.CENTER);;
			button[i].setFont(fbutton);
		}
		
		panel[0].setLayout(new GridLayout(1,5));
		panel[1].setLayout(new GridLayout(1,5));
		for(int i=0;i<5;i++){
			panel[0].add(label[i]);
		}
		for(int i=0;i<5;i++){
			panel[1].add(button[i]);
		}
		panel[2].add(label[5]);

		frame.getContentPane().add(BorderLayout.CENTER, panel[0]);
		frame.getContentPane().add(BorderLayout.SOUTH, panel[1]);
		frame.getContentPane().add(BorderLayout.NORTH, panel[2]);
		frame.setSize(1500,900);
		frame.setVisible(true);
	}
	
	//call different methods for different movies in different classes
	class chooseKONG implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new KONG();
		}
	}
	
	class chooseLOGAN implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new LOGAN();
		}	
	}
	
	class chooseBEAUTY implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new BEAUTY();
		}
	}
	
	class chooseMOON implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new MOON();
		}
	}
	
	class chooseLALA implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new LALA();
		}
	}
	
}