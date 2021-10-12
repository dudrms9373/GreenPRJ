package ProjectUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSlider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirstPage extends JFrame implements ActionListener, MouseListener{
	JPanel panel;
	JButton UserLoginButton, TrainerLoginButton;
	public FirstPage() {
		this.setTitle("첫 화면");
		panel = new JPanel();
		panel.setLayout(null);
		
		getContentPane().add(panel);
		
		UserLoginButton = new JButton("회원");
		UserLoginButton.setBounds(23, 97, 97, 170);
		panel.add(UserLoginButton);
		
		TrainerLoginButton = new JButton("트레이너");
		TrainerLoginButton.setBounds(163, 97, 97, 170);
		panel.add(TrainerLoginButton);
		
		this.UserLoginButton.addActionListener(this);
		this.TrainerLoginButton.addActionListener(this);
		
		this.UserLoginButton.addMouseListener(this);
		this.TrainerLoginButton.addMouseListener(this);
		
		
		
		this.setVisible(true);
		this.setSize(300,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FirstPage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "회원"     : new UserLoginPage() ; break;
		// case "트레이너" : -------------------------------- 트레이너 화면 입력하기!!
		
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.dispose();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
