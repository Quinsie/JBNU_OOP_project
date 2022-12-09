package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class base_gui extends JFrame {
	public static void main (String[] args) {
		new base_gui();
		base_gui panel = new base_gui();
	}
	
	public base_gui() {	
		super ("수강신청 도우미"); //창 이름
		this.setSize(1600, 900); //가로, 세로
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //창을 닫으면 프로그램 실행을 멈춤
		this.setVisible(true); //프레임을 보이게 함
		setResizable(false); //창 크기 변경 불가
	}
}