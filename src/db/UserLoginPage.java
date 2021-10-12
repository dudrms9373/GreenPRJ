package ProjectUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UserLoginPage extends JFrame{
	private JTextField IDtextField;
	private JTextField PWtextField;
	public UserLoginPage(){
		
		this.setTitle("회원 로그인 화면");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원이신가요?");
		lblNewLabel.setBounds(0, 22, 434, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 23));
		getContentPane().add(lblNewLabel);
		
		JLabel Label_ID = new JLabel("ID : ");
		Label_ID.setBounds(36, 68, 57, 15);
		getContentPane().add(Label_ID);
		
		JLabel Label_PW = new JLabel("PW : ");
		Label_PW.setBounds(36, 119, 57, 15);
		getContentPane().add(Label_PW);
		
		JButton Login_Button = new JButton("로그인");
		Login_Button.setBounds(32, 183, 81, 27);
		getContentPane().add(Login_Button);
		
		JButton JoinButton = new JButton("회원가입");
		JoinButton.setBounds(125, 183, 81, 27);
		getContentPane().add(JoinButton);
		
		JButton IdSearchButton = new JButton("ID 찾기");
		IdSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		IdSearchButton.setBounds(218, 183, 81, 27);
		getContentPane().add(IdSearchButton);
		
		JButton PWSearchButton = new JButton("PW 찾기");
		PWSearchButton.setBounds(311, 183, 81, 27);
		getContentPane().add(PWSearchButton);
		
		IDtextField = new JTextField();
		IDtextField.setToolTipText("내용을 입력해주세요");
		IDtextField.setBounds(125, 65, 219, 21);
		getContentPane().add(IDtextField);
		IDtextField.setColumns(10);
		
		PWtextField = new JTextField();
		PWtextField.setToolTipText("내용을 입력해주세요");
		PWtextField.setColumns(10);
		PWtextField.setBounds(125, 116, 219, 21);
		getContentPane().add(PWtextField);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(460,360);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	public static void main(String[] args) {
		UserLoginPage b =new UserLoginPage();
	}
}
