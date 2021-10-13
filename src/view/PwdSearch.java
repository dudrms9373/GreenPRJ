package ProjectUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PwdSearch extends JFrame{
	private JTextField textFieldName;
	private JTextField textFieldBirth;
	private JTextField textFieldId;

	public PwdSearch() {
		this.setTitle("비밀번호 찾기");
		
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
		
		JLabel LabelId = new JLabel("ID");
		LabelId.setFont(new Font("굴림", Font.PLAIN, 15));
		LabelId.setHorizontalAlignment(SwingConstants.CENTER);
		LabelId.setBounds(28, 185, 114, 42);
		getContentPane().add(LabelId);
		
		JButton IdSearchButton = new JButton("비밀번호 찾기");
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
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(154, 194, 231, 25);
		getContentPane().add(textFieldId);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new PwdSearch();

	}

}
