package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import gui.window.AddWindow;
import gui.window.CheckWindow;
import gui.window.RemoveWindow;

public class Frame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1110743075299004665L;
	
	// Field
	public final static Font font1 = new Font("Malgun Gothic", Font.BOLD, 13);
	public final static Font font2 = new Font("Malgun Gothic", Font.PLAIN, 11);
	public final static Font font3 = new Font("Malgun Gothic", Font.BOLD, 15);
	public final static Font font4 = new Font("Malgun Gothic", Font.BOLD, 20);
	
	public static String name = new String();
	public static String place = new String();
	public static int day, start, end;
	
	JMenuItem fileMenuItem;
	JPanel titlePanel, buttonPanel, timetablePanel;
	Button[] btn;
	public static JLabel[] timetable;
	public static boolean[] isLoaded;
	public static int[][] placeStatus, typeStatus;
	
	// Constructor
	public Frame() {
		this.setTitle("수강신청 도우미");
		this.setSize(480, 420);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		createMenu();
		createTitle();
		createButton();
		createTimetable();
		
		this.setVisible(true);
	}
	
	// Methods
	private void createMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menuList = new JMenu();
		fileMenuItem = new JMenuItem();
		
		fileMenuItem.addActionListener(this);
		
		fileMenuItem.setText("Exit");
		menuList.add(fileMenuItem);
		menuList.setText("File");
		menuList.setFont(font1);
		menuList.addSeparator();
		menubar.add(menuList);
		
		this.setJMenuBar(menubar);
	}
	
	private void createTitle() {
		titlePanel = new JPanel();
		titlePanel.setBounds(30, 10, 500, 50);
		titlePanel.setLayout(null);
		
		JLabel text = new JLabel("육상 선수 될 거야? 시간표 점검 해야지!");
		text.setFont(font4);
		titlePanel.add(text);
		text.setBounds(0, 0, 500, 50);
		
		this.add(titlePanel);
	}
	
	private void createButton() {
		buttonPanel = new JPanel();
		btn = new Button[4];
		buttonPanel.setBounds(30, 70, 420, 50);
		buttonPanel.setLayout(null);
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button();
			btn[i].addActionListener(this);
			
			if (i == 0) btn[i].setText("추가");
			else if (i == 1) btn[i].setText("삭제");
			else if (i == 2) btn[i].setText("초기화");
			else btn[i].setText("분석");
			
			btn[i].setFont(font1);
			buttonPanel.add(btn[i]);
			btn[i].setBounds(105 * i, 0, 90, 40);
		}
		
		this.add(buttonPanel);
	}
	
	private void createTimetable() {
		timetablePanel = new JPanel();
		timetablePanel.setBounds(30, 130, 405, 200);
		timetablePanel.setLayout(new GridLayout(4, 2));
		
		isLoaded = new boolean[8];
		timetable = new JLabel[8];
		placeStatus = new int[5][13];
		typeStatus = new int[5][13];
		
		for (int i = 0; i < 8; i++) {
			timetable[i] = new JLabel();
			timetable[i].setOpaque(true);
			timetable[i].setBackground(Color.LIGHT_GRAY);
			timetable[i].setText("빈칸");
			timetable[i].setFont(font1);
			timetable[i].setVerticalAlignment(JLabel.CENTER);
			timetable[i].setHorizontalAlignment(JLabel.CENTER);
			
			isLoaded[i] = false;
			
			timetablePanel.add(timetable[i]);
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 13; j++) {
				placeStatus[i][j] = 0;
				typeStatus[i][j] = 0;
			}
		}
		
		this.add(timetablePanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == fileMenuItem) System.exit(0);
		else if (e.getSource() == btn[0]) addTimetable();
		else if (e.getSource() == btn[1]) removeTimetable();
		else if (e.getSource() == btn[2]) resetTimetable();
		else if (e.getSource() == btn[3]) checkTimetable();
	}
	
	private void addTimetable() {
		@SuppressWarnings("unused")
		AddWindow wtemp = new AddWindow();
	}
	private void removeTimetable() {
		@SuppressWarnings("unused")
		RemoveWindow wtemp = new RemoveWindow();
	}
	private void resetTimetable() {
		for (int i = 0; i < 8; i++) {
			timetable[i].setText("빈칸");
			isLoaded[i] = false;
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 13; j++) {
				typeStatus[i][j] = 0;
				placeStatus[i][j] = 0;
			}
		}
	}
	private void checkTimetable() {
		@SuppressWarnings("unused")
		CheckWindow wtemp = new CheckWindow();
	}
}
