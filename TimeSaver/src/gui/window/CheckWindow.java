package gui.window;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import gui.Frame;

public class CheckWindow extends JDialog
{
	private static final long serialVersionUID = -9036648438113942749L;
	
	// Field
	JPanel textPanel, outputPanel;
	JTextArea textArea;
	
	// Constructor
	public CheckWindow() {
		this.setTitle("시간표 분석");
		this.setSize(360, 320);
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		createText();
		createOutput();
		
		this.setVisible(true);
	}
	
	// Method
	private void createText() {
		textPanel = new JPanel();
		textPanel.setBounds(100, 5, 200, 50);
		textPanel.setLayout(null);
		
		JLabel text = new JLabel();
		text.setText("시간표 분석 결과");
		text.setFont(Frame.font4);
		textPanel.add(text);
		text.setBounds(0, 0, 200, 50);
		
		this.add(textPanel);
	}
	
	private void createOutput() {
		outputPanel = new JPanel();
		outputPanel.setBounds(30, 60, 290, 190);
		outputPanel.setLayout(null);
		
		JTextArea jta = new JTextArea();
		jta.setEditable(false);
		jta.setLineWrap(true);
		
		int[][] in_a_row = new int[8][2];
		int idx = 0;
		boolean flag = false;
		
		for (int i = 0; i < 5; i++) { // 연강 찾기
			for (int j = 1; j < 13; j++) {
				if (Frame.typeStatus[i][j] != Frame.typeStatus[i][j - 1]) {
					if (Frame.typeStatus[i][j] != 0 && Frame.typeStatus[i][j - 1] != 0) {
						flag = true;
						in_a_row[idx][0] = Frame.typeStatus[i][j - 1];
						in_a_row[idx][1] = Frame.typeStatus[i][j];
						idx++;
					}
				}
			}
		}
		
		if (!flag) { // 연강 없음
			jta.append("연강이 하나도 없군요! 걱정할 필요가 없습니다!");
		} else {
			jta.append("다음 " + idx + "개의 연강 발견!\n\n");
			for (int i = 0; i < idx; i++) {
				jta.append(Frame.timetable[in_a_row[i][0] - 1].getText() + ", ");
				jta.append(Frame.timetable[in_a_row[i][1] - 1].getText() + ", ");
				// 소요시간 계산하는 프로그램 파트 필요
				jta.append("소요시간 NULL분.\n");
			}
			
			// 집계된 소요시간 중 일부가 기준치 이상이라면 경고문구 출력 구현 필요
			
		}
		
		outputPanel.add(jta);
		jta.setBounds(0, 0, 290, 190);
		
		this.add(outputPanel);
	}

	
}
