package main_pkg;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	public Frame() {
		this.setTitle("수강신청 도우미");
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		createMenu();
		createTimetable();
		createTimetableTitle();
		
		this.setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu();
		JMenu editMenu = new JMenu();
		
		fileMenu.setText("File");
		fileMenu.add(new JMenuItem("1"));
		fileMenu.add(new JMenuItem("2"));
		fileMenu.add(new JMenuItem("3"));
		fileMenu.addSeparator();
		
		editMenu.setText("Edit");
		editMenu.add(new JMenuItem("1"));
		editMenu.add(new JMenuItem("2"));
		editMenu.add(new JMenuItem("3"));
		editMenu.addSeparator();
		
		mb.add(fileMenu);
		mb.add(editMenu);
		
		this.setJMenuBar(mb);
	}
	
	public void createTimetable() {
		JPanel timetable = new JPanel();
		timetable.setBounds(30, 70, 575, 560);
		timetable.setLayout(null);
		
		JButton timetableButton = new JButton();
		timetableButton.setText("시간표 수정 (시간표 추가 예정)");
		timetable.add(timetableButton);
		timetableButton.setBounds(0, 0, 575, 560);
		
		this.add(timetable);
	}
	
	public void createTimetableTitle() {
		JPanel title = new JPanel();
		title.setBounds(30, 20, 200, 20);
		title.setLayout(null);
		
		JLabel text = new JLabel();
		text.setText("시간표");
		title.add(text);
		text.setBounds(0, 0, 200, 20);
		
		this.add(title);
	}
}
