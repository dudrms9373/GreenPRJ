package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.FitnessDao;
import model.MemberVo;

public class JoinPage extends JFrame implements ActionListener {

	JPanel p;

	JTextField TextFieldID, TextFieldName, TextFieldBirth, TextFieldPWD, TextFieldTel, TextFieldGender, TextFieldAddres;

	JPasswordField PasswordFieldPWD;

	JTextArea taIntro;

	JButton ButtonJoin, ButtonCancel;

	private JTextField textFieldHeight, textFieldWeight;

	public JoinPage() {
		this.setTitle("회원가입");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(380, 610);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// 라벨
		JLabel LabelName = new JLabel("이름");
		LabelName.setBounds(25, 30, 77, 26);
		getContentPane().add(LabelName);

		JLabel LabelBirth = new JLabel("생년월일");
		LabelBirth.setBounds(25, 80, 77, 26);
		getContentPane().add(LabelBirth);

		JLabel LabelID = new JLabel("ID");
		LabelID.setBounds(25, 130, 77, 26);
		getContentPane().add(LabelID);

		JLabel LabelPWD = new JLabel("PWD");
		LabelPWD.setBounds(25, 180, 77, 26);
		getContentPane().add(LabelPWD);

		JLabel LabelTel = new JLabel("전화번호");
		LabelTel.setBounds(25, 230, 77, 26);
		getContentPane().add(LabelTel);

		JLabel LabelGender = new JLabel("성별");
		LabelGender.setBounds(25, 280, 77, 26);
		getContentPane().add(LabelGender);

		JLabel LableAddres = new JLabel("주소(~동 까지)");
		LableAddres.setBounds(25, 330, 99, 26);
		getContentPane().add(LableAddres);

		// 텍스트 필드
		TextFieldName = new JTextField();
		TextFieldName.setBounds(123, 30, 204, 25);
		TextFieldName.setFont(new Font("굴림", Font.PLAIN, 13));
		getContentPane().add(TextFieldName);
		TextFieldName.setColumns(10);

		TextFieldBirth = new JTextField();
		TextFieldBirth.setBounds(123, 80, 204, 25);
		TextFieldBirth.setFont(new Font("굴림", Font.PLAIN, 13));
		TextFieldBirth.setColumns(10);
		getContentPane().add(TextFieldBirth);

		TextFieldID = new JTextField();
		TextFieldID.setBounds(123, 130, 204, 25);
		TextFieldID.setFont(new Font("굴림", Font.PLAIN, 13));
		TextFieldID.setColumns(10);
		getContentPane().add(TextFieldID);

		TextFieldPWD = new JTextField();
		TextFieldPWD.setBounds(123, 180, 204, 25);
		TextFieldPWD.setFont(new Font("굴림", Font.PLAIN, 13));
		TextFieldPWD.setColumns(10);
		getContentPane().add(TextFieldPWD);

		TextFieldTel = new JTextField();
		TextFieldTel.setBounds(123, 230, 204, 25);
		TextFieldTel.setFont(new Font("굴림", Font.PLAIN, 13));
		TextFieldTel.setColumns(10);
		getContentPane().add(TextFieldTel);

		TextFieldGender = new JTextField();
		TextFieldGender.setBounds(123, 280, 204, 25);
		TextFieldGender.setFont(new Font("굴림", Font.PLAIN, 13));
		TextFieldGender.setColumns(10);
		getContentPane().add(TextFieldGender);

		TextFieldAddres = new JTextField();
		TextFieldAddres.setBounds(123, 330, 204, 25);
		TextFieldAddres.setFont(new Font("굴림", Font.PLAIN, 13));
		TextFieldAddres.setColumns(10);
		getContentPane().add(TextFieldAddres);

		// 버튼
		ButtonJoin = new JButton("가입");
		ButtonJoin.setBounds(47, 494, 111, 45);
		getContentPane().add(ButtonJoin);

		ButtonCancel = new JButton("취소");
		ButtonCancel.setBounds(198, 494, 111, 45);
		getContentPane().add(ButtonCancel);

		JLabel heightLabel = new JLabel("키");
		heightLabel.setBounds(25, 380, 99, 26);
		getContentPane().add(heightLabel);

		JLabel weightLabel = new JLabel("몸무게");
		weightLabel.setBounds(25, 430, 99, 26);
		getContentPane().add(weightLabel);

		textFieldHeight = new JTextField();
		textFieldHeight.setFont(new Font("굴림", Font.PLAIN, 13));
		textFieldHeight.setColumns(10);
		textFieldHeight.setBounds(123, 381, 204, 25);
		getContentPane().add(textFieldHeight);

		textFieldWeight = new JTextField();
		textFieldWeight.setFont(new Font("굴림", Font.PLAIN, 13));
		textFieldWeight.setColumns(10);
		textFieldWeight.setBounds(123, 431, 204, 25);
		getContentPane().add(textFieldWeight);
		this.setVisible(true);

		// 이벤트
		this.ButtonCancel.addActionListener(this);
		this.ButtonJoin.addActionListener(this);

	}

//	public static void main(String[] args) {
//		new JoinPage();
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "가입":
			insertUser();
			this.dispose();
			new UserLoginPage();
			break;
		case "취소":
			this.dispose();
			new UserLoginPage();
			break;
		}

	}

	private void insertUser() {
		FitnessDao fd = new FitnessDao();
		MemberVo fv = new MemberVo(TextFieldName.getText(), TextFieldBirth.getText(), TextFieldID.getText(),
				TextFieldPWD.getText(), TextFieldTel.getText(), TextFieldGender.getText(), TextFieldAddres.getText(),
				textFieldHeight.getText(), textFieldWeight.getText());
		int num = fd.JoinFitness(fv);
		// 메세지 상자 출력
		if (num == 1) {
			JOptionPane.showMessageDialog(null, "회원가입 완료", "완료", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			new UserLoginPage();
		} else {
			JOptionPane.showMessageDialog(null, "아이디가 중복되었습니다", "중복", JOptionPane.CANCEL_OPTION);
			this.TextFieldID.requestFocus();
		}

	}
}
