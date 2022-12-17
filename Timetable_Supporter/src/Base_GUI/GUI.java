//package Base_GUI;
//
//import javax.swing.*;
//import javax.swing.event.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class GUI extends JFrame {
//	public static void main(String[] args) {
//		new GUI();
//	}
//	
//	public GUI() {
//		window();
//		Button();
//		//text();
//	}
//	
//	void window() { //창 띄우기 함수
//		//JFrame f = new JFrame("수강신청 도우미"); //JFrame 정의 (public class GUI extends JFrame하면 따로 선언 필요 없음)
//		setTitle ("수강신청 도우미"); //창 이름 설정
//		setSize(1600, 900); //창 크기 설정
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫았을 때 실행 종료
//		setVisible(true); //프레임을 보이게 함
//		setResizable(false); //창 크기 변경 불가
//		setLocationRelativeTo(null); //창이 띄워질 때 화면 중앙에 띄워지게 함
//	}
//	
////	void text() { //창에 텍스트 출력 함수
////		JLabel lb = new JLabel("수강신청 도우미 V1.0"); //텍스트 설정
////		this.add(lb);
////		//Font font = new Font("맑은 고딕", Font.PLAIN, 30); //폰트, 글자 크기 설정
////		
////		//lb.setFont(font); //폰트 생성
////		//add(lb); //폰트 적용
////		
////		//contentPane().add(lb); //화면에 라벨 추가
////	}
//
//	void Button() { //메뉴 버튼 함수
//		getContentPane().setLayout(null);
//		JButton btn1 = new JButton("거리 측정"); //"거리 측정"이라는 이름의 button을 만든다
//		JButton btn2 = new JButton("전공학점 관리");
//		JButton btn3 = new JButton("수업 추천");
//		JButton btn4 = new JButton("재수강 추천");
//		
//		btn1.setBounds(700, 50, 122, 30); //버튼 위치, 크기 조정 (가로위치, 세로위치, 가로길이, 세로길이)
//		btn2.setBounds(830, 50, 122, 30);
//		btn3.setBounds(960, 50, 122, 30);
//		btn4.setBounds(1090, 50, 122, 30);
//		
//		getContentPane().add(btn1); //화면에 버튼 추가
//		getContentPane().add(btn2);
//		getContentPane().add(btn3);
//		getContentPane().add(btn4);
//		
//		btn1.addActionListener(envent -> { //버튼을 누르면 이벤트가 발생
//			
//		});
//	}
//	
//	MyPanel p = new MyPanel();
//	class MyPanel extends JPanel{ //사각형 띄우는 클래스
//		public void paintComponent(Graphics g){
//			super.paintComponent(g);
//	        g.setColor(Color.BLUE);
//	        g.drawRect(10, 10, 50, 50);
//	   }
//	}
//	
//}
