package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PTreserved extends JFrame {

	JLabel lblReserved, lblAM, lblPM;

	JButton JBpreview, JB9h, JB10h, JB11h, JB12h, JB13h, JB14h, JB15h, JB16h, 
	        JB17h, JB18h, JB19h, JB20h;

	public PTreserved() {
		
		//Label~
		lblReserved = new JLabel("PT 예약");
		lblReserved.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblReserved.setBounds(160, 10, 400, 39); // 좌표 변경
		getContentPane().add(lblReserved);

		lblAM = new JLabel("오전");
		lblAM.setFont(new Font("굴림", Font.BOLD, 40));
		lblAM.setHorizontalAlignment(SwingConstants.CENTER);
		lblAM.setBounds(27, 58, 95, 120);
		getContentPane().add(lblAM);

		lblPM = new JLabel("오후");
		lblPM.setFont(new Font("굴림", Font.BOLD, 40));
		lblPM.setHorizontalAlignment(SwingConstants.CENTER);
		lblPM.setBounds(27, 248, 95, 120);
		getContentPane().add(lblPM);
		
		
		//오늘을 포함한 8일이 포함된 콤보박스 작성
		Calendar today= Calendar.getInstance();
		int year=today.get(Calendar.YEAR);
		int month=today.get(Calendar.MONTH);
		int date=today.get(Calendar.DATE);
		String fmt="%4d-%02d-%02d";
		String[] days=new String[8];
		
		for(int i=0 ; i<days.length ; i++){
			String day = String.format(fmt,year,month+1,date+i);
			days[i]=day;
			
		}
		
		cbDate=new JComboBox<>(days);
		cbDate.setBounds(400, 50, 150, 20);
		getContentPane().add(cbDate);
		//오늘의 예약 일정 표시(default)
		lblReserved.setText((String) cbDate.getSelectedItem()+" 예약 일정");

		
		//버튼들 9~20시
		
		JBpreview = new JButton("<이전");
		getContentPane().setLayout(null);
		JBpreview.setBounds(12, 10, 79, 23);
		getContentPane().add(JBpreview);
		
		JB9h = new JButton("09:00");
		JB9h.setBounds(134, 77, 170, 60);
		getContentPane().add(JB9h);

		JB10h = new JButton("10:00");
		JB10h.setBounds(313, 77, 170, 60);
		getContentPane().add(JB10h);

		JB12h = new JButton("11:00");
		JB12h.setBounds(134, 136, 170, 60);
		getContentPane().add(JB12h);

		JB11h = new JButton("12:00");
		JB11h.setBounds(313, 136, 170, 60);
		getContentPane().add(JB11h);

		JB13h = new JButton("13:00");
		getContentPane().add(JB13h);
		JB13h.setBounds(134, 209, 170, 60);

		JB14h = new JButton("14:00");
		getContentPane().add(JB14h);
		JB14h.setBounds(313, 209, 170, 60);

		JB18h = new JButton("18:00");
		getContentPane().add(JB18h);
		JB18h.setBounds(313, 327, 170, 60);

		JB15h = new JButton("15:00");
		getContentPane().add(JB15h);
		JB15h.setBounds(134, 268, 170, 60);

		JB19h = new JButton("19:00");
		getContentPane().add(JB19h);
		JB19h.setBounds(134, 386, 170, 60);

		JB16h = new JButton("16:00");
		getContentPane().add(JB16h);
		JB16h.setBounds(313, 268, 170, 60);

		JB20h = new JButton("20:00");
		getContentPane().add(JB20h);
		JB20h.setBounds(313, 386, 170, 60);

		JB17h = new JButton("17:00");
		getContentPane().add(JB17h);
		JB17h.setBounds(134, 327, 170, 60);
		
		// 시간 버튼들을 ArrayList에 담음
		ArrayList<JButton> btnSet = new ArrayList<JButton>();
		btnSet.add(0, JB9h);
		btnSet.add(1, JB10h);
		btnSet.add(2, JB11h);
		btnSet.add(3, JB12h);
		btnSet.add(4, JB13h);
		btnSet.add(5, JB14h);
		btnSet.add(6, JB15h);
		btnSet.add(7, JB16h);
		btnSet.add(8, JB17h);
		btnSet.add(8, JB18h);
		btnSet.add(8, JB19h);
		btnSet.add(8, JB20h);
		
		//default = 모두 예약 가능 상태
		for (JButton jBtn : btnSet) {
			jBtn.setBackground(Color.GREEN);
		}
		
		
		
		
		
		// ActionListener에 버튼 등록
		///날짜 콤보 박스
		this.cbDate.addActionListener(this);
		///이전 버튼 
		this.JBpreview.addActionListener(this);;
		///시간 버튼
		for (JButton jBtn : btnSet) {
			jBtn.addActionListener(this);
		}

		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); //중앙에 열리도록 조정
		this.setVisible(true);

	}
	
	// ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("<이전")){ //이전 버튼
			dispose(); new UserMenu();
		}
		String time="";
		for (int num = 9; num <= 20; num++) {
			time=String.format("%02d:00", num);
			
			if(e.getActionCommand().equals(time)){
				String resDate="날짜 박스 getText() "+time; //수정 필요 (미완성)
				System.out.println(resDate);
			}
			
		}
		
		//콤보 박스의 날짜를 선택할 때마다 레이블의 텍스트 변경
		lblReserved.setText((String) cbDate.getSelectedItem()+" 예약 일정");
	}


//	public static void main(String[] args) {
//		new PTreserved();
//
//	}
}
