package main_pkg;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	public Frame() {
		this.setTitle("수강신청 도우미");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		createMenu();
		createTimetable();
		
		this.setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu();
		JMenu editMenu = new JMenu();
		
		fileMenu.setText("File");
		editMenu.setText("Edit");
		mb.add(fileMenu);
		mb.add(editMenu);
		
		this.setJMenuBar(mb);
	}
	
	public void createTimetable() {
		JPanel timetable = new JPanel();
		timetable.setLayout(null);
		
		JButton timetableButton = new JButton();
		timetableButton.setText("시간표 수정 (시간표 추가 예정)");
		timetable.add(timetableButton);
		timetableButton.setBounds(30, 75, 575, 555);
		
		this.add(timetable);
	}
}
