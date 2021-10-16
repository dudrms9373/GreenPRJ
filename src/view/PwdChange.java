package view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.FitnessDao;

public class PwdChange extends JFrame implements ActionListener{
	
	JTextArea resultTextArea;
	JButton loginGoButton;
	JTextField newPwdTextField;
	String a ; // 이거 뭐징.. 필요없으면 지우고, 필요한거면 주석이라도 달아줘요..ㅠㅠ -김영근
	
	
	public PwdChange(String name,String id) {
		 a= id;
		this.setTitle("비밀번호 변경");
		
		getContentPane().setLayout(null);
		
		resultTextArea = new JTextArea(name +"님 비밀번호를 재설정 하세요.\n 아이디 "+a);
		resultTextArea.setBounds(86, 23, 267, 49);
		getContentPane().add(resultTextArea);
		
		loginGoButton = new JButton("로그인창으로 가기");
		loginGoButton.setBounds(137, 175, 181, 49);
		getContentPane().add(loginGoButton);
		
		JLabel newPwdLabel = new JLabel("새 비밀번호 입력");
		newPwdLabel.setBounds(12, 105, 107, 28);
		getContentPane().add(newPwdLabel);
		
		this.loginGoButton.addActionListener(this);
		
		newPwdTextField = new JTextField();
		newPwdTextField.setBounds(127, 106, 226, 28);
		getContentPane().add(newPwdTextField);
		newPwdTextField.setColumns(10);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		chagePwd(); new UserLoginPage();
			
	}
	
	private void chagePwd() {
		System.out.println("아이디 : "+ a);
		System.out.println("변경할 비번 : " + newPwdTextField.getText());
		FitnessDao fd = new FitnessDao();
		fd.newPwd(newPwdTextField.getText() , a);
		//dispose();
		
	}
}
