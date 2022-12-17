package Base_GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//////////////
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//////////////

public class Gui_temp extends JFrame {
	
	public static void main(String[] args) {
		
		//window 띄우기
		JFrame f = new JFrame("수강신청 도우미"); //창 이름 설정
		f.setSize(1600, 900); //창 크기 설정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫았을 때 실행 종료
		f.setVisible(true); //프레임을 보이게 함
		f.setResizable(false); //창 크기 변경 불가
		f.setLocationRelativeTo(null); //창이 띄워질 때 화면 중앙에 띄워지게 함
		
		//메뉴 버튼
		f.getContentPane().setLayout(null);
		JButton btn1 = new JButton("거리 측정"); //"거리 측정"이라는 이름의 button을 만든다
		JButton btn2 = new JButton("성적, 전공학점 관리");
		JButton btn3 = new JButton("수업 추천");
		JButton btn4 = new JButton("재수강 추천");
		
		btn1.setBounds(700, 50, 145, 30); //버튼 위치, 크기 조정 (가로위치, 세로위치, 가로길이, 세로길이)
		btn2.setBounds(850, 50, 145, 30);
		btn3.setBounds(1000, 50, 145, 30);
		btn4.setBounds(1150, 50, 145, 30);
		
		f.getContentPane().add(btn1); //화면에 버튼 추가
		f.getContentPane().add(btn2);
		f.getContentPane().add(btn3);
		f.getContentPane().add(btn4);
		
		//사각형 그리기
		DrawPanel drawpanel = new DrawPanel();
		
		f.add(drawpanel); //draw panel을 frame에 추가
		
		f.getContentPane().add(drawpanel);
		f.setVisible(true);
		
		
		//내 성적 입력
//		String data[][] = {
//				{"객프", "A+", "3", "전공"}
//		};
//		
//		String column[] = {"과목", "성적", "학점", "전공"};
//		
//		JTable jt = new JTable(data, column);
//		jt.setCellSelectionEnabled(true);

		
		//학점 관리
		//표 만들기 : 과목 최대 8개 (전진설 포함)
		//과목 학점 계산해서 총 학점에서 제외
//		String header1[] = {"과목", "성적", "학점", "교양/전공/일선"}; //표 제목줄
//		String data1[][] = {
//				{"대진설", "P", "0.5", "기타"}
//		};
		
//		DefaultTableModel model = new DefaultTableModel(data1, header1);
//		JTable table1 = new JTable(model);
//		JScrollPane scrollpane1 = new JScrollPane(table1);
		
//		JPanel panel = new JPanel();
//		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//		
//		
//		JTextField nameField = new JTextField(5);
//		JTextField sbj1 = new JTextField(3);
//		JTextField sbj2 = new JTextField(3);
//		JTextField sbj3 = new JTextField(3);
//		
//		panel.add(nameField);
//		panel.add(sbj1);
//		panel.add(sbj2);
//		panel.add(sbj3);
//		
//		JButton addBtn = new JButton("추가");
//		
//		addBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				String inputStr[] = new String[4];
//				
//				inputStr[0] = nameField.getText();
//				inputStr[1] = sbj1.getText();
//				inputStr[2] = sbj2.getText();
//				inputStr[3] = sbj3.getText();
//				
//				model.addRow(inputStr);
//				
//				nameField.setText("");
//				sbj1.setText("");
//				sbj2.setText("");
//				sbj3.setText("");
//				
//			}
//		});// addActionListener
//		
//		JButton cancelBtn = new JButton("삭제");
//		
//		 cancelBtn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				if(table1.getSelectedRow() == -1) {
//					return;
//				}
//				else {
//					model.removeRow(table1.getSelectedRow());
//				}
//				
//			}
//		});
//		 
//		 panel.add(addBtn);
//		 panel.add(cancelBtn);
//		 
//		 f.add(scrollpane1, BorderLayout.CENTER);
//		 f.add(panel, BorderLayout.SOUTH);
//		 f.pack();
//		 f.setVisible(true);
//		 
//		 //////////////////////////////////////////////////////////////////////////
//		 
//		
//		//우리 과 졸업학점 : 교양 38 / 전필 18 / 전선 + 심화전공 60 / 총 140
//		//우리과 졸업학점 표
//		String header2[] = {"교양", "전공필수", "전공선택", "심화전공", "졸업학점"};
//		String data[][] = {
//				{"38", "18", "30", "30", "140"}
//		};
//		
//		JTable table2 = new JTable(data, header2);
//		JScrollPane scrollpane2 = new JScrollPane(table2);
//		f.add(scrollpane2);
//		
		
		//내가 들어야 할 학점 표
		
	}
}

//사각형 그리기
class DrawPanel extends JPanel {
	public void paint (Graphics g) {
		super.paint(g);
		g.drawRect(50, 50, 100, 200); //사각형을 그린다 (x, y, 가로 길이, 세로 길이)
	}
}
