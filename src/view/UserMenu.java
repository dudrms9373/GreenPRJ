package ProjectUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserMenu extends JFrame{
	
	String UserName=null;
	JButton LogoutButton, PTButton, InfoButton, ExtensionButton;
	public UserMenu() {
		this.setTitle("4. 회원로그인");
		
		
		JLabel TitleLabel = new JLabel("<html><body style='text-align:center;'>어서오세요."+UserName+"님!<br />오늘도 득근 하세요!!</body></html>",JLabel.CENTER);
		TitleLabel.setFont(new Font("굴림", Font.BOLD, 30));
		TitleLabel.setBounds(54, 10, 400, 113);
		getContentPane().add(TitleLabel);
		
		LogoutButton = new JButton("로그아웃");
		LogoutButton.setBounds(463, 24, 97, 36);
		getContentPane().add(LogoutButton);
		
		PTButton = new JButton("<html><body style='text-align:center;'>PT 및 상담<br />예약</body></html>");
		PTButton.setBounds(54, 149, 105, 230);
		getContentPane().add(PTButton);
		
		InfoButton = new JButton("내 정보");
		InfoButton.setBounds(240, 149, 97, 230);
		getContentPane().add(InfoButton);
		
		ExtensionButton = new JButton("연장하기");
		ExtensionButton.setBounds(418, 149, 97, 230);
		getContentPane().add(ExtensionButton);
		
		getContentPane().setLayout(null);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	
}
