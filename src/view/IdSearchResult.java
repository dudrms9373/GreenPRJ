package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.FitnessVo;

import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IdSearchResult extends JFrame implements ActionListener{
	JTextArea IdResulttextArea;
	JButton LoginGoButton;
	FitnessVo fv2;
	public IdSearchResult(String name, String id) {
		this.setTitle("아이디 확인");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		IdResulttextArea = new JTextArea();
		IdResulttextArea.setText(name+" 님의 아이디는 " + id +" 입니다");
		IdResulttextArea.setBounds(55, 43, 327, 84);
		getContentPane().add(IdResulttextArea);
		
		LoginGoButton = new JButton("로그인 창으로 가기");
		LoginGoButton.setBounds(124, 186, 197, 35);
		getContentPane().add(LoginGoButton);
		
		this.LoginGoButton.addActionListener(this);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new IdSearchResult("3","3");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "로그인 창으로 가기": dispose(); new UserLoginPage(); break;
		}
		
	}
}
