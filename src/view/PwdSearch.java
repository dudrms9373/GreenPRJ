package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.FitnessDao;
import model.MemberVo;

public class PwdSearch extends JFrame implements ActionListener{
	private JTextField textFieldName;
	private JTextField textFieldBirth;
	private JTextField textFieldId;
	JButton backButton;
	JButton IdSearchButton;

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
		
		IdSearchButton = new JButton("비밀번호 찾기");
		IdSearchButton.setFont(new Font("굴림", Font.BOLD, 16));
		IdSearchButton.setBounds(75, 262, 343, 50);
		getContentPane().add(IdSearchButton);
		
		backButton = new JButton("<이전");
		backButton.setBounds(12, 10, 81, 30);
		getContentPane().add(backButton);
		
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
		
		this.backButton.addActionListener(this);
		this.IdSearchButton.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "<이전": dispose(); new UserLoginPage(); break;
		case "비밀번호 찾기": PwdSearch1(); break;
		}
		
	}

	private void PwdSearch1() {
		FitnessDao fd = new FitnessDao();
		String name =this.textFieldName.getText();
		String birth =this.textFieldBirth.getText();
		String id = this.textFieldId.getText();
		
		FitnessVo result = fd.PwdSearch(name, birth, id);
		if( result != null  ) {
			JOptionPane.showMessageDialog(null, "비밀번호 찾기 성공");
			dispose();
			new PwdChange(result.getName(),result.getId());
			
		}else{
			JOptionPane.showMessageDialog(null,"조회된 비밀번호가 없습니다","에러 메세지",JOptionPane.OK_OPTION );
		          // 화면 초기화
		          clearData();
		}
		
	}
	public void clearData() {
		this.textFieldName.setText("");
		this.textFieldBirth.setText("");
		this.textFieldId.setText("");
	}

}
