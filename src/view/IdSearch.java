package ProjectUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class IdSearch extends JFrame{
	private JTextField textFieldName;
	private JTextField textFieldBirth;
	private JTextField textFieldTel;
	public IdSearch() {
		this.setTitle("아이디 찾기");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel LabelName = new JLabel("이름");
		LabelName.setFont(new Font("굴림", Font.PLAIN, 15));
		LabelName.setHorizontalAlignment(SwingConstants.CENTER);
		LabelName.setBounds(28, 45, 114, 42);
		getContentPane().add(LabelName);
		
		JLabel LabelBirth = new JLabel("생년월일");
		LabelBirth.setHorizontalAlignment(SwingConstants.CENTER);
		LabelBirth.setFont(new Font("굴림", Font.PLAIN, 15));
		LabelBirth.setBounds(28, 115, 114, 42);
		getContentPane().add(LabelBirth);
		
		JLabel LabelTel = new JLabel("전화번호");
		LabelTel.setFont(new Font("굴림", Font.PLAIN, 15));
		LabelTel.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTel.setBounds(28, 185, 114, 42);
		getContentPane().add(LabelTel);
		
		JButton IdSearchButton = new JButton("아이디 찾기");
		IdSearchButton.setFont(new Font("굴림", Font.BOLD, 16));
		IdSearchButton.setBounds(75, 262, 343, 50);
		getContentPane().add(IdSearchButton);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(154, 54, 231, 25);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldBirth = new JTextField();
		textFieldBirth.setColumns(10);
		textFieldBirth.setBounds(154, 124, 231, 25);
		getContentPane().add(textFieldBirth);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(154, 194, 231, 25);
		getContentPane().add(textFieldTel);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		new IdSearch();

	}
}
