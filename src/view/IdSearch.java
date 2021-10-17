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

public class IdSearch extends JFrame implements ActionListener{
	
	private JTextField textFieldName, textFieldBirth, textFieldTel;
	JButton IdSearchButton, backButton;
	private boolean check = true;
	
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
		
		IdSearchButton = new JButton("아이디 찾기");
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
		
		backButton = new JButton("<이전");
		backButton.setBounds(12, 10, 81, 30);
		getContentPane().add(backButton);
		
		this.backButton.addActionListener(this);
		this.IdSearchButton.addActionListener(this);
		
		this.setVisible(true);
	}
	

	


	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "<이전":this.dispose(); new UserLoginPage(); break;
		case "아이디 찾기": 
			nullCheck(check);
			if (check == false) // check로 이름 / 생년월일 / 전번 안적었을때 다이얼로그 1개만 뜨게
				break;
			IdSearch(); break;
		
		}
		
	}


	
	public void IdSearch() {
		FitnessDao fd = new FitnessDao();
		String name =this.textFieldName.getText();
		String birth =this.textFieldBirth.getText();
		String tel = this.textFieldTel.getText();
		
	
		MemberVo result = fd.IdSearch(name, birth, tel);
		if( result != null  ) {
			String msg=result.getName()+" 님의 아이디는 "+result.getId()+" 입니다";
			JOptionPane.showMessageDialog
						(null, msg, "확인", 
								JOptionPane.INFORMATION_MESSAGE);
			dispose();
		        new UserLoginPage();
		}else{
			JOptionPane.showMessageDialog(null,"조회된 아이디가 없습니다","에러 메세지",JOptionPane.OK_OPTION );
		          // 화면 초기화
		          clearData();
		}
		
	}
		// textfield Null인지 아닌지 확인
	public boolean nullCheck(boolean check) {
		FitnessDao fd = new FitnessDao();
		String name = this.textFieldName.getText();
		String birth = this.textFieldBirth.getText();
		String tel = this.textFieldTel.getText();
				
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "에러 메세지", JOptionPane.OK_OPTION);
			textFieldName.requestFocus(); // 포커스 이동
		}

		else if (birth.equals("")) {
			JOptionPane.showMessageDialog(null, "생년월일을 입력 해주세요.", "에러 메세지", JOptionPane.OK_OPTION);
			textFieldBirth.requestFocus();
		} else if (tel.equals("")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력 해주세요.", "에러 메세지", JOptionPane.OK_OPTION);
			textFieldTel.requestFocus();
		}
		
		check = false;
		this.check = check;
		return check;
		
	}
	
	public void clearData() {
		this.textFieldName.setText("");
		this.textFieldBirth.setText("");
		this.textFieldTel.setText("");
	}
}
