package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstPage extends JFrame{
	JPanel panel;
	JButton btn;
	public FirstPage() {
		this.setTitle("연습용");
		panel = new JPanel();
		panel.setLayout(null);
		
		getContentPane().add(panel);
		
		JButton UserLoginButton = new JButton("회원");
		UserLoginButton.setBounds(23, 97, 97, 170);
		panel.add(UserLoginButton);
		
		JButton TrainerLoginButton = new JButton("트레이너");
		TrainerLoginButton.setBounds(163, 97, 97, 170);
		panel.add(TrainerLoginButton);
		
		this.setVisible(true);
		this.setSize(300,400);
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FirstPage();

	}
}
