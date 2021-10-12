package ProjectUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class UserMenu extends JFrame{
	
	String UserName=null;
	public UserMenu() {
		this.setTitle("4. 회원로그인");
		
		
		JLabel lblNewLabel = new JLabel("<html><body style='text-align:center;'>어서오세요."+UserName+"님!<br />오늘도 득근 하세요!!</body></html>",JLabel.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(54, 10, 400, 113);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("로그아웃");
		btnNewButton.setBounds(463, 24, 97, 36);
		getContentPane().add(btnNewButton);
		
		JButton btnPt = new JButton("<html><body style='text-align:center;'>PT 및 상담<br />예약</body></html>");
		btnPt.setBounds(54, 149, 105, 230);
		getContentPane().add(btnPt);
		
		JButton btnNewButton_3 = new JButton("내 정보");
		btnNewButton_3.setBounds(240, 149, 97, 230);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("연장하기");
		btnNewButton_3_1.setBounds(413, 149, 97, 230);
		getContentPane().add(btnNewButton_3_1);
		this.setVisible(true);
		  
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
	}

	public static void main(String[] args) {
		UserMenu a= new UserMenu();
	}
}
