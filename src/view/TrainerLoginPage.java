package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class TrainerLoginPage extends JFrame {
	
	private JTextField ID_TF;
	private JPasswordField PWD_PF;

	public TrainerLoginPage() {
		this.setSize(445,290);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setVisible(true);
		
		JLabel Title_Label = new JLabel("관리자 ID와 PWD로 로그인 하세요");
		Title_Label.setFont(new Font("굴림", Font.BOLD, 21));
		Title_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Label.setBounds(0, 10, 407, 52);
		getContentPane().add(Title_Label);
		
		JLabel ID_Label = new JLabel("ID:");
		ID_Label.setFont(new Font("굴림", Font.BOLD, 15));
		ID_Label.setBounds(56, 77, 57, 15);
		getContentPane().add(ID_Label);
		
		JLabel Pwd_Label = new JLabel("PWD:");
		Pwd_Label.setFont(new Font("굴림", Font.BOLD, 15));
		Pwd_Label.setBounds(56, 128, 57, 15);
		getContentPane().add(Pwd_Label);
		
		ID_TF = new JTextField();
		ID_TF.setBounds(145, 73, 219, 25);
		getContentPane().add(ID_TF);
		ID_TF.setColumns(10);
		
		PWD_PF = new JPasswordField();
		PWD_PF.setBounds(145, 124, 219, 25);
		getContentPane().add(PWD_PF);
		
		JButton Login_Button = new JButton("로그인");
		Login_Button.setFont(new Font("굴림", Font.PLAIN, 15));
		Login_Button.setBounds(85, 183, 81, 30);
		getContentPane().add(Login_Button);
		
		JButton Cancel_Button = new JButton("취소");
		Cancel_Button.setFont(new Font("굴림", Font.PLAIN, 15));
		Cancel_Button.setBounds(263, 183, 81, 30);
		getContentPane().add(Cancel_Button);
	
	}

//	public static void main(String[] args) {
//		new TrainerLogin();
//
//	}
}