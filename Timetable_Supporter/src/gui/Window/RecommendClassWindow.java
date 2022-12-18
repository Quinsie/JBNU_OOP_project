package gui.Window;

import javax.swing.JDialog;
import javax.swing.JLabel;

import gui.Frame;

public class RecommendClassWindow extends JDialog 
{
	// Fields
	JLabel templib = new JLabel();
	String text;
	
	// Constructor
	public RecommendClassWindow(String str) {
		text = str + " has been pressed!";
		
		getContentPane().add(templib);
		templib.setText(text.toString());
		templib.setFont(Frame.font3);
		templib.setVerticalAlignment(JLabel.CENTER);
		templib.setHorizontalAlignment(JLabel.CENTER);
		
		this.setTitle(str);
		this.setSize(450, 300);
		this.setModal(true);
		this.setResizable(false); // cannot resize this window
		this.setLocationRelativeTo(null); // place this window to the middle of monitor
		this.setVisible(true);
	}
}
