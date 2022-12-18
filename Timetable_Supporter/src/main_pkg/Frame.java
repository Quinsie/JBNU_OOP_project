package main_pkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	private Font font1 = new Font("Malgun Gothic", Font.BOLD, 13);
	private Font font2 = new Font("Malgun Gothic", Font.PLAIN, 11);
	private Font font3 = new Font("Malgun Gothic", Font.BOLD, 15);
	private Font font4 = new Font("Malgun Gothic", Font.BOLD, 25);
	
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
		createStatus();
		createItemButton();
		
		this.setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu();
		JMenu editMenu = new JMenu();
		
		fileMenu.setText("File");
		fileMenu.setFont(font1);
		fileMenu.add(new JMenuItem("1"));
		fileMenu.add(new JMenuItem("2"));
		fileMenu.add(new JMenuItem("3"));
		fileMenu.addSeparator();
		
		editMenu.setText("Edit");
		editMenu.setFont(font1);
		editMenu.add(new JMenuItem("1"));
		editMenu.add(new JMenuItem("2"));
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
		timetableButton.setText("여기를 눌러 시간표 추가");
		timetableButton.setFont(font3);
		timetable.add(timetableButton);
		timetableButton.setBounds(0, 0, 575, 560);
		
		this.add(timetable);
	}
	
	public void createTimetableTitle() {
		JPanel title = new JPanel();
		title.setBounds(30, 10, 1000, 50);
		title.setLayout(null);
		
		JLabel text = new JLabel();
		text.setText("시간표 설정 :: 하단 상자를 눌러주세요!");
		text.setFont(font4);
		title.add(text);
		text.setBounds(0, 0, 1000, 50);
		
		this.add(title);
	}
	
	public void createStatus() {
		JPanel status = new JPanel();
		status.setBackground(Color.gray);
		status.setBounds(650, 70, 580, 560);
		status.setLayout(new BorderLayout());
		
		JLabel text = new JLabel();
		text.setText("여기에 시간표 검진 상태 출력");
		text.setFont(font1);
		text.setHorizontalAlignment(JLabel.CENTER);
		status.add(text, BorderLayout.CENTER);
		
		this.add(status);
	}
	
	public void createItemButton() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(650, 20, 580, 580);
		buttonPanel.setLayout(null);
		
		for (int i = 0; i < 4; i++) {
			JButton temp = new JButton();
			
			if (i == 0) {
				temp.setText("시간표 검사");
			} else if (i == 1) {
				temp.setText("수강 가능 과목");
			} else if (i == 2) {
				temp.setText("과목 추천");
			} else {
				temp.setText("재수강 추천");
			}
			
			temp.setFont(font3);
			buttonPanel.add(temp);
			temp.setBounds(148 * i, 0, 135, 40);
		}
		
		this.add(buttonPanel);
	}
}
