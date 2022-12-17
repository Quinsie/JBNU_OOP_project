package Base_GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class gui_temp extends JFrame {
	public static void main(String[] args) {
		
		//window 띄우기
		JFrame f = new JFrame();
		f.setTitle ("수강신청 도우미"); //창 이름 설정
		f.setSize(1600, 900); //창 크기 설정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫았을 때 실행 종료
		f.setVisible(true); //프레임을 보이게 함
		f.setResizable(false); //창 크기 변경 불가
		f.setLocationRelativeTo(null); //창이 띄워질 때 화면 중앙에 띄워지게 함
		
		//메뉴 버튼
		f.getContentPane().setLayout(null);
		JButton btn1 = new JButton("거리 측정"); //"거리 측정"이라는 이름의 button을 만든다
		JButton btn2 = new JButton("전공학점 관리");
		JButton btn3 = new JButton("수업 추천");
		JButton btn4 = new JButton("재수강 추천");
		
		f.getContentPane().add(btn1); //화면에 버튼 추가
		f.getContentPane().add(btn2);
		f.getContentPane().add(btn3);
		f.getContentPane().add(btn4);
	}
}
