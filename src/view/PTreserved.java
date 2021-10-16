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
		lblReserved.setBounds(215, 10, 223, 39);
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

		
		//버튼들 9~20시
		
		JBpreview = new JButton("<이전");
		getContentPane().setLayout(null);
		JBpreview.setBounds(12, 10, 79, 23);
		getContentPane().add(JBpreview);
		
		JB9h = new JButton("AM 09:00");
		JB9h.setBounds(134, 77, 170, 60);
		getContentPane().add(JB9h);

		JB10h = new JButton("AM 10:00");
		JB10h.setBounds(313, 77, 170, 60);
		getContentPane().add(JB10h);

		JB12h = new JButton("PM 12:00");
		JB12h.setBounds(134, 136, 170, 60);
		getContentPane().add(JB12h);

		JB11h = new JButton("AM 11:00");
		JB11h.setBounds(313, 136, 170, 60);
		getContentPane().add(JB11h);

		JB13h = new JButton("PM 13:00");
		getContentPane().add(JB13h);
		JB13h.setBounds(134, 209, 170, 60);

		JB14h = new JButton("PM 14:00");
		getContentPane().add(JB14h);
		JB14h.setBounds(313, 209, 170, 60);

		JB18h = new JButton("PM 18:00");
		getContentPane().add(JB18h);
		JB18h.setBounds(313, 327, 170, 60);

		JB15h = new JButton("PM 15:00");
		getContentPane().add(JB15h);
		JB15h.setBounds(134, 268, 170, 60);

		JB19h = new JButton("PM 19:00");
		getContentPane().add(JB19h);
		JB19h.setBounds(134, 386, 170, 60);

		JB16h = new JButton("PM 16:00");
		getContentPane().add(JB16h);
		JB16h.setBounds(313, 268, 170, 60);

		JB20h = new JButton("PM 20:00");
		getContentPane().add(JB20h);
		JB20h.setBounds(313, 386, 170, 60);

		JB17h = new JButton("PM 17:00");
		getContentPane().add(JB17h);
		JB17h.setBounds(134, 327, 170, 60);
		

		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

//	public static void main(String[] args) {
//		new PTreserved();
//
//	}
}