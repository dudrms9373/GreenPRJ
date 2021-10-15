package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.MemberVo;

public class PwdSearchResult extends JFrame implements ActionListener{
	JTextArea IdResulttextArea;
	JButton LoginGoButton;
	MemberVo fv2;
	public PwdSearchResult(String name, String pwd) {
		this.setTitle("비밀번호 확인");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		IdResulttextArea = new JTextArea();
		IdResulttextArea.setText(name+" 님의 비밀번호는 " + pwd +" 입니다");
		IdResulttextArea.setBounds(55, 43, 327, 84);
		getContentPane().add(IdResulttextArea);
		
		LoginGoButton = new JButton("로그인 창으로 가기");
		LoginGoButton.setBounds(124, 186, 197, 35);
		getContentPane().add(LoginGoButton);
		
		this.LoginGoButton.addActionListener(this);
		
		this.setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "로그인 창으로 가기": dispose(); new UserLoginPage(); break;
		}
		
	}
}
