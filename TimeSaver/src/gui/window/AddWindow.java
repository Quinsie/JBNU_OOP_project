package gui.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.Button;
import gui.Frame;

public class AddWindow extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 405625404978074095L;
	
	// Field
	private JTextField textfield;
	final String[] day = { "월요일", "화요일", "수요일", "목요일", "금요일" };
	final String[] start = { "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" };
	final String[] end = { "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" };
	final String[] place = { "공과대학 1호관", "공과대학 2호관", "공과대학 3호관", "공과대학 4호관", "공과대학 5호관", "공과대학 6호관",
							 "공과대학 7호관", "공과대학 8호관", "공과대학 9호관", "공과대학 부속공장", "상과대학 1호관", "상과대학 2호관", 
							 "상과대학 3호관", "정보전산원 교육동", "인문사회관", "인문대학 1호관", "인문대학 2호관", "생활과학대학",
							 "우림인재등용관", "삼성문화회관", "대운동장", "소운동장", "사범대학 본관", "사범대학 과학관", "뉴실크로드센터", 
							 "학술문화관", "예지원", "법학전문대학원", "법학도서관", "약학대학", "진수당", "교육연구동", "체육관", 
							 "자연과학대학 본관", "자연과학대학 1호관", "자연과학대학 2호관", "자연과학대학 3호관", "자연과학대학 4호관", 
							 "자연과학대학 5호관", "예술대학 본관", "예술대학 2호관", "예술대학 3호관", "동아리전용관", "사범대학 예체능관", 
							 "농업생명과학대학 1호관", "농업생명과학대학 2호관", "농업생명과학대학 3호관", "농업생명과학대학 4호관" };
	
	JPanel textPanel, inputPanel, buttonPanel;
	Button btn1, btn2;
	JComboBox<Object> dayList, startList, endList, placeList;
	
	// Constructor
	public AddWindow() {
		this.setTitle("시간표 추가");
		this.setSize(360, 320);
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		createText();
		createInput();
		createButton();
		
		this.setVisible(true);
	}
	
	// Method
	private void createText() {
		textPanel = new JPanel();
		textPanel.setBounds(120, 5, 200, 50);
		textPanel.setLayout(null);
		
		JLabel text = new JLabel();
		text.setText("시간표 추가");
		text.setFont(Frame.font4);
		textPanel.add(text);
		text.setBounds(0, 0, 200, 50);
		
		this.add(textPanel);
	}
	
	private void createInput() {
		inputPanel = new JPanel();
		inputPanel.setBounds(20, 70, 320, 160);
		inputPanel.setLayout(null);
		
		JLabel textTitle = new JLabel();
		textTitle.setText("수업명 입력 : ");
		textTitle.setFont(Frame.font1);
		inputPanel.add(textTitle);
		textTitle.setBounds(0, 0, 90, 20);
		
		textfield = new JTextField(30);
		textfield.addActionListener(this);
		inputPanel.add(textfield);
		textfield.setBounds(95, 0, 200, 24);
		
		dayList = new JComboBox<Object>(day);
		dayList.setSelectedIndex(0);
		dayList.addActionListener(this);
		inputPanel.add(dayList);
		dayList.setBounds(0, 90, 70, 20);
		
		startList = new JComboBox<Object>(start);
		startList.setSelectedIndex(0);
		startList.addActionListener(this);
		inputPanel.add(startList);
		startList.setBounds(80, 90, 40, 20);
		
		endList = new JComboBox<Object>(end);
		endList.setSelectedIndex(0);
		endList.addActionListener(this);
		inputPanel.add(endList);
		endList.setBounds(130, 90, 40, 20);
		
		placeList = new JComboBox<Object>(place);
		placeList.setSelectedIndex(0);
		placeList.addActionListener(this);
		inputPanel.add(placeList);
		placeList.setBounds(180, 90, 125, 20);
		
		this.add(inputPanel);
	}
	
	private void createButton() {
		buttonPanel = new JPanel();
		buttonPanel.setBounds(80, 240, 200, 30);
		buttonPanel.setLayout(null);
		
		btn1 = new Button();
		btn1.addActionListener(this);
		btn1.setText("추가");
		btn1.setFont(Frame.font1);
		buttonPanel.add(btn1);
		btn1.setBounds(0, 0, 80, 30);
		
		btn2 = new Button();
		btn2.addActionListener(this);
		btn2.setText("취소");
		btn2.setFont(Frame.font1);
		buttonPanel.add(btn2);
		btn2.setBounds(120, 0, 80, 30);
		
		this.add(buttonPanel);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn2) { // 취소 버튼 누르면
			this.dispose();
		} else if (e.getSource() == btn1) { // 확인 버튼 누르면
			int daytemp = dayList.getSelectedIndex();
			int starttemp = startList.getSelectedIndex();
			int endtemp = endList.getSelectedIndex() + 1;
			int placetemp = endList.getSelectedIndex() + 1;
			int myNum = 0;
			boolean flag = true;
			
			if (endtemp <= starttemp) { this.dispose(); return; }
			
			for (int i = starttemp; i < endtemp; i++) // 시간표를 추가할 수 있는지 검사
				if (Frame.placeStatus[daytemp][i] != 0) {
					flag = false;
					break;
				}
			
			if (!flag) { this.dispose(); return; } // 경고창 띄우고 세션 종료하기 (미구현)
			
			flag = false;
			for (int i = 0; i < 8; i++) {
				if (!Frame.isLoaded[i]) {
					Frame.isLoaded[i] = true;
					flag = true;
					myNum = i + 1;
					break;
				}
			}
			
			if (!flag) { this.dispose(); return; } // 경고창 띄우고 세션 종료하기
			
			for (int i = starttemp; i < endtemp; i++) {
				Frame.typeStatus[daytemp][i] = myNum;
				Frame.placeStatus[daytemp][i] = placetemp;
			}
			
			Frame.timetable[myNum - 1].setText(textfield.getText());
			this.dispose();
		}
	}
}
