package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserMenu extends JFrame implements ActionListener{
	
	
	JButton LogoutButton, PTButton, InfoButton, ExtensionButton;
	private String name = "";
	private String id="";
	
	public UserMenu(String name, String id) {
		this.setTitle("4. 회원로그인");
		this.name = name;
		this.id = id;
		
		JLabel TitleLabel = new JLabel("<html><body style='text-align:center;'>어서오세요."+name+"님!<br />오늘도 득근 하세요!!</body></html>",JLabel.CENTER);
		TitleLabel.setFont(new Font("굴림", Font.BOLD, 30));
		TitleLabel.setBounds(54, 10, 400, 113);
		getContentPane().add(TitleLabel);
		
		LogoutButton = new JButton("로그아웃");
		LogoutButton.setBounds(463, 24, 97, 36);
		getContentPane().add(LogoutButton);
		
		PTButton = new JButton("PT예약");
		PTButton.setBounds(54, 149, 105, 230);
		getContentPane().add(PTButton);
		
		InfoButton = new JButton("내 정보");
		InfoButton.setBounds(240, 149, 97, 230);
		getContentPane().add(InfoButton);
		
		ExtensionButton = new JButton("연장하기");
		ExtensionButton.setBounds(418, 149, 97, 230);
		getContentPane().add(ExtensionButton);
		
		getContentPane().setLayout(null);
		
		this.LogoutButton.addActionListener(this);
		this.InfoButton.addActionListener(this);
		this.PTButton.addActionListener(this);
		this.ExtensionButton.addActionListener(this);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "로그아웃" : new UserLoginPage(); this.dispose(); break;
		case "내 정보" : new MyInfo(name, id); this.dispose(); break;
		case "연장하기" :new PTPrice(name,id); this.dispose(); break;
		case "PT예약" : new PTreserved(name, id); this.dispose();break;
		
		}
		
	}
	public static void main(String[] args) {
		new UserMenu("d", "s");
	}

	
}
