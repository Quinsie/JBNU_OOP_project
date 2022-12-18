package gui.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Button;
import gui.Frame;

public class SetTimetableWindow extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 2465482692336387618L;
	
	// Fields
	JPanel textPanel, buttonPanel;
	Button btn1, btn2;
	Frame f;
	
	// Constructor
	public SetTimetableWindow(Frame inputF) {
		f = inputF;
		this.setTitle("시간표 수정");
		this.setSize(900, 600);
		this.setModal(true);
		this.setResizable(false); // cannot resize this window
		this.setLocationRelativeTo(null); // place this window to the middle of monitor
		this.setLayout(null);
		
		createText();
		createButton();
		
		this.setVisible(true);
	}
	
	private void createText() {
		textPanel = new JPanel();
		textPanel.setBounds(100, 10, 200, 50);
		textPanel.setLayout(null);
		
		JLabel text = new JLabel();
		text.setText("시간표를 수정하시겠습니까?");
		text.setFont(Frame.font1);
		textPanel.add(text);
		text.setBounds(0, 0, 200, 50);
		
		this.add(textPanel);
	}
	private void createButton() {
		buttonPanel = new JPanel();
		buttonPanel.setBounds(100, 100, 400, 100);
		buttonPanel.setLayout(null);
		
		btn1 = new Button();
		btn1.addActionListener(this);
		btn1.setText("네");
		btn1.setFont(Frame.font2);
		buttonPanel.add(btn1);
		btn1.setBounds(0, 0, 70, 50);
		
		btn2 = new Button();
		btn2.addActionListener(this);
		btn2.setText("아니오");
		btn2.setFont(Frame.font2);
		buttonPanel.add(btn2);
		btn2.setBounds(100, 0, 70, 50);
		
		this.add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getSource() == btn1) {
			f.timetableImage.setText("시간표 변경!");
			f.timetableImage.setVerticalAlignment(JLabel.CENTER);
			f.timetableImage.setHorizontalAlignment(JLabel.CENTER);
			this.dispose();
		} else {
			this.dispose();
		}
	}
}
