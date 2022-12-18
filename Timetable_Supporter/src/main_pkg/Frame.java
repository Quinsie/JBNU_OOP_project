package main_pkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 3953023869638367038L;
	
	// Fields
	public final static Font font1 = new Font("Malgun Gothic", Font.BOLD, 13);
	public final static Font font2 = new Font("Malgun Gothic", Font.PLAIN, 11);
	public final static Font font3 = new Font("Malgun Gothic", Font.BOLD, 15);
	public final static Font font4 = new Font("Malgun Gothic", Font.BOLD, 25);
	
	Button[] itemButton; // main screen selection button
	JMenu[] menuList; // tool menuBarlist
	JMenuItem[] fileMenuItem, editMenuItem; // menuBarlist components 
	
	JMenuBar menubar; // menuBar
	JPanel titlePanel, timetablePanel, statusPanel, buttonPanel; // panels
	JLabel statusText;
	Button timetableButton;
	
	// Constructor
	public Frame() { // main frame
		this.setTitle("수강신청 도우미");
		this.setSize(1280, 720); // default size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // cannot resize this window
		this.setLocationRelativeTo(null); // place this window to the middle of monitor
		this.setLayout(null);
		
		// methods
		createMenu();
		createTimetable();
		createTimetableTitle();
		createStatus();
		createItemButton();
		
		this.setVisible(true);
	}
	
	// Methods
	public void createMenu() { // create menuBar
		menubar = new JMenuBar();
		menuList = new JMenu[2];
		fileMenuItem = new JMenuItem[3];
		editMenuItem = new JMenuItem[2];
		
		for (int i = 0; i < fileMenuItem.length; i++) { // make and configure fileMenuItem
			fileMenuItem[i] = new JMenuItem();
			fileMenuItem[i].addActionListener(this);
			
			if (i == 0) {
				fileMenuItem[i].setText("Save");
			} else if (i == 1) {
				fileMenuItem[i].setText("Load");
			} else if (i == 2) {
				fileMenuItem[i].setText("Exit");
			}
		}
		
		for (int i = 0; i < editMenuItem.length; i++) { // make and configure editMenuItem
			editMenuItem[i] = new JMenuItem();
			if (i == 0) {
				editMenuItem[i].setText("Add");
			} else if (i == 1) {
				editMenuItem[i].setText("Remove");
			}
		}
		
		for (int i = 0; i < menuList.length; i++) { // make menuList
			menuList[i] = new JMenu();
			menuList[i].setFont(font1);
			
			if (i == 0) { // fileMenu
				menuList[i].setText("File");
				for (int j = 0; j < fileMenuItem.length; j++) {
					menuList[i].add(fileMenuItem[j]);
				}
			} else if (i == 1) { // editMenu
				menuList[i].setText("Edit");
				for (int j = 0; j < editMenuItem.length; j++) {
					menuList[i].add(editMenuItem[j]);
				}
			}
			
			menuList[i].addSeparator();
			menubar.add(menuList[i]);
		}
		
		this.setJMenuBar(menubar);
	}
	
	public void createTimetableTitle() { // create timetable title panel
		titlePanel = new JPanel();
		titlePanel.setBounds(30, 10, 1000, 50);
		titlePanel.setLayout(null);
		
		JLabel text = new JLabel();
		text.setText("시간표 설정 :: 하단 상자를 눌러주세요!");
		text.setFont(font4);
		titlePanel.add(text);
		text.setBounds(0, 0, 1000, 50);
		
		this.add(titlePanel);
	}
	
	public void createTimetable() { // create timetable panel
		timetablePanel = new JPanel();
		timetablePanel.setBounds(30, 70, 575, 560);
		timetablePanel.setLayout(null);
		
		timetableButton = new Button();
		timetableButton.setText("여기를 눌러 시간표 추가");
		timetableButton.setFont(font3);
		timetableButton.addActionListener(this);
		timetablePanel.add(timetableButton);
		timetableButton.setBounds(0, 0, 575, 560);
		
		this.add(timetablePanel);
	}
	
	public void createStatus() { // create status panel
		statusPanel = new JPanel();
		statusPanel.setBackground(Color.gray);
		statusPanel.setBounds(650, 70, 580, 560);
		
		statusText = new JLabel();
		statusText.setText("여기에 시간표 검진 상태 출력");
		statusText.setFont(font1);
		statusPanel.add(statusText);
		
		this.add(statusPanel);
	}
	
	public void createItemButton() { // create selection button panel
		itemButton = new Button[4];
		buttonPanel = new JPanel();
		buttonPanel.setBounds(650, 20, 580, 580);
		buttonPanel.setLayout(null);
		
		for (int i = 0; i < 4; i++) {
			itemButton[i] = new Button();
			itemButton[i].addActionListener(this);
			//getContentPane().add(itemButton[i]);
			
			if (i == 0) itemButton[i].setText("시간표 검사");
			else if (i == 1) itemButton[i].setText("수강 가능 과목");
			else if (i == 2) itemButton[i].setText("과목 추천 분석");
			else itemButton[i].setText("재수강 추천 분석");
			
			itemButton[i].setFont(font1);
			buttonPanel.add(itemButton[i]);
			itemButton[i].setBounds(148 * i, 0, 135, 40);
		}
		
		this.add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == fileMenuItem[2]) { // exit button
			System.exit(0);
		}
		else if (e.getSource() == timetableButton) { // set timetable
			Window subWindow = new Window(e.getActionCommand());
		}
		else if (e.getSource() == itemButton[0]) {
			statusText.setText("분석 완료!");
		}
		else if (e.getSource() == itemButton[1]) { // 수강 가능 과목 알림
			Window subWindow = new Window(e.getActionCommand());
		}
		else if (e.getSource() == itemButton[2]) { // 과목 추천 분석
			Window subWindow = new Window(e.getActionCommand());
		}
		else if (e.getSource() == itemButton[3]) { // 재수강 추천 분석
			Window subWindow = new Window(e.getActionCommand());
		}
		
	}
}
