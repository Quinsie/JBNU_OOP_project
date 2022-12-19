package gui.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Button;
import gui.Frame;

public class RemoveWindow extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 2776793703222140481L;
	
	// Field
	final String[] number = { "1", "2", "3", "4", "5", "6", "7", "8" };
	
	JPanel textPanel, inputPanel, buttonPanel;
	JComboBox<Object> remove;
	Button btn1, btn2;
	
	// Constructor
	public RemoveWindow() {
		this.setTitle("시간표 삭제");
		this.setSize(240, 160);
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		createText();
		createInput();
		createButton();
		
		this.setVisible(true);
	}
	
	// Method
	private void createText() {
		textPanel = new JPanel();
		textPanel.setBounds(40, 0, 160, 50);
		textPanel.setLayout(null);
		
		JLabel text = new JLabel();
		text.setText("삭제할 시간표 번호 선택");
		text.setFont(Frame.font1);
		textPanel.add(text);
		text.setBounds(0, 0, 160, 50);
		
		this.add(textPanel);
	}
	
	private void createInput() {
		inputPanel = new JPanel();
		inputPanel.setBounds(100, 45, 40, 20);
		inputPanel.setLayout(null);
		
		remove = new JComboBox<Object>(number);
		remove.setSelectedIndex(0);
		remove.addActionListener(this);
		inputPanel.add(remove);
		remove.setBounds(0, 0, 40, 20);
		
		this.add(inputPanel);
	}
	
	private void createButton() {
		buttonPanel = new JPanel();
		buttonPanel.setBounds(25, 80, 190, 30);
		buttonPanel.setLayout(null);
		
		btn1 = new Button();
		btn1.addActionListener(this);
		btn1.setText("삭제");
		btn1.setFont(Frame.font1);
		buttonPanel.add(btn1);
		btn1.setBounds(0, 0, 80, 30);
		
		btn2 = new Button();
		btn2.addActionListener(this);
		btn2.setText("취소");
		btn2.setFont(Frame.font1);
		buttonPanel.add(btn2);
		btn2.setBounds(100, 0, 80, 30);
		
		this.add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn2) {
			this.dispose();
		} else if (e.getSource() == btn1) {
			int selectedIdx = remove.getSelectedIndex();
			int typenum;
			
			if (!Frame.isLoaded[selectedIdx]) { // 지울 게 없으니까 return
				this.dispose();
				return;
			}
			
			Frame.isLoaded[selectedIdx] = false;
			
			typenum = selectedIdx + 1;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 13; j++) {
					if (Frame.typeStatus[i][j] == typenum) {
						Frame.typeStatus[i][j] = 0;
						Frame.placeStatus[i][j] = 0;
					}
				}
			}
			
			Frame.timetable[selectedIdx].setText("빈칸");
			this.dispose();
		}
	}
	
}
