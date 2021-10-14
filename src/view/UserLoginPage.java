package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.FitnessDao;
import model.FitnessVo;
import view.JoinPage;

public class UserLoginPage extends JFrame implements ActionListener{
	private JTextField IDtextField;
	JPasswordField PWField;
	JButton Login_Button, JoinButton, IdSearchButton, PWSearchButton, BackButton;
	public String idcheck ;
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
		
		Login_Button = new JButton("로그인");
		Login_Button.setBounds(16, 183, 81, 30);
		getContentPane().add(Login_Button);
		
		JoinButton = new JButton("회원가입");
		JoinButton.setBounds(109, 183, 97, 30);
		getContentPane().add(JoinButton);
		
		IdSearchButton = new JButton("ID 찾기");		
		IdSearchButton.setBounds(218, 183, 81, 30);
		getContentPane().add(IdSearchButton);
		
		PWSearchButton = new JButton("PW 찾기");
		PWSearchButton.setBounds(311, 183, 97, 30);
		getContentPane().add(PWSearchButton);
		
		IDtextField = new JTextField();
		IDtextField.setToolTipText("내용을 입력해주세요");
		IDtextField.setBounds(125, 65, 219, 25);
		getContentPane().add(IDtextField);
		IDtextField.setColumns(10);
		
		PWField = new JPasswordField();
		PWField.setToolTipText("내용을 입력해주세요");
		PWField.setColumns(10);
		PWField.setBounds(125, 116, 219, 25);
		getContentPane().add(PWField);
		
		BackButton = new JButton("<이전");
		BackButton.setBounds(16, 10, 80, 27);
		getContentPane().add(BackButton);
		
		this.BackButton.addActionListener(this);
		this.JoinButton.addActionListener(this);
		this.IdSearchButton.addActionListener(this);
		this.PWSearchButton.addActionListener(this);
		this.Login_Button.addActionListener(this);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(445,290);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	public static void main(String[] args) {
		new UserLoginPage();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "로그인" :   login();  break;
		case "회원가입" : this.dispose(); new JoinPage(); break;
		case "ID 찾기" : this.dispose(); new IdSearch(); break;
		case "PW 찾기" : this.dispose(); new PwdSearch(); break;
		case "<이전" : this.dispose(); new FirstPage(); break;
		}
	}

	private void login() {
		FitnessDao fd = new FitnessDao();
		FitnessVo fv = new FitnessVo();
		int n = fd.loginCheck(this.IDtextField.getText(), this.PWField.getText());
		if(n == 1) {
			fv.setId(this.IDtextField.getText());     
			String name = fd.loginCheck1(fv.getId());
			this.dispose();
			new UserMenu(name);
		}else if(n == -1 ) {
			this.IDtextField.setText("");
			this.PWField.setText("");
		}
	}
	
	
}
