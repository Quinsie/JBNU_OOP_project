package main_pkg;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		////////////////////////////////////////////////
		
		JPanel timetable = new JPanel();
		timetable.setLayout(null);
		
		JButton timetableButton = new JButton();
		timetableButton.setText("시간표 수정 (시간표 추가 예정)");
		timetable.add(timetableButton);
		timetableButton.setBounds(30, 75, 575, 555);
		
		frame.add(timetable);
		
		////////////////////////////////////////////////
		
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu();
		JMenu editMenu = new JMenu();
		
		fileMenu.setText("File");
		editMenu.setText("Edit");
		mb.add(fileMenu);
		mb.add(editMenu);
		
		frame.setTitle("수강신청 도우미");
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setJMenuBar(mb);
		frame.setVisible(true);
	}
}
