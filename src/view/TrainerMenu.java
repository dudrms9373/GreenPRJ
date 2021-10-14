package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.FitnessDao;

public class TrainerMenu extends JFrame implements ActionListener, MouseListener {
	JPanel leftpanel, rightpanel;
	JLabel inName, inGender, inTelLabel, inAddressLabel, inBookLabel, inRemainLabel;
	JTextArea infoTextArea;
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel dtm;
	private JTextField textField;
	Vector v;
	Vector column;

	public TrainerMenu() {
		this.setTitle("트레이너 화면");

		leftpanel = new JPanel();
		leftpanel.setBounds(0, 0, 356, 651);
		getContentPane().add(leftpanel);
		leftpanel.setLayout(null);

		JLabel NameLabel = new JLabel("회원 이름     : ");
		NameLabel.setBounds(21, 10, 82, 29);
		leftpanel.add(NameLabel);

		JLabel genderLabel = new JLabel("성별              : ");
		genderLabel.setBounds(21, 60, 82, 29);
		leftpanel.add(genderLabel);

		JLabel telLabel = new JLabel("전화번호      :");
		telLabel.setBounds(21, 110, 82, 29);
		leftpanel.add(telLabel);

		JLabel addressLabel = new JLabel("주소              : ");
		addressLabel.setBounds(21, 160, 82, 29);
		leftpanel.add(addressLabel);

		JLabel bookLabel = new JLabel("예약 시간     : ");
		bookLabel.setBounds(21, 210, 82, 29);
		leftpanel.add(bookLabel);

		JLabel remainLabel = new JLabel("남은 일 수    :");
		remainLabel.setBounds(21, 260, 82, 29);
		leftpanel.add(remainLabel);

		JLabel infoLabel = new JLabel("회원 특이사항");
		infoLabel.setBounds(21, 333, 102, 25);
		leftpanel.add(infoLabel);

		infoTextArea = new JTextArea();
		infoTextArea.setBounds(21, 368, 323, 234);
		leftpanel.add(infoTextArea);

		JButton btnNewButton_2 = new JButton("수정");
		btnNewButton_2.setBounds(143, 616, 82, 29);
		leftpanel.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("삭제");
		btnNewButton_2_1.setBounds(246, 616, 82, 29);
		leftpanel.add(btnNewButton_2_1);

		rightpanel = new JPanel();
		rightpanel.setBounds(357, 0, 527, 651);
		getContentPane().add(rightpanel);
		rightpanel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("회원관리");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel_5.setBounds(27, 10, 276, 80);
		rightpanel.add(lblNewLabel_5);

		JButton btnNewButton = new JButton("로그아웃");
		btnNewButton.setBounds(340, 24, 91, 29);
		rightpanel.add(btnNewButton);

		dtm = new DefaultTableModel(column, 1);

		table = new JTable();

		table.setModel(new DefaultTableModel(getDataList(), getColums()) {
			public boolean isCellEditable(int row, int column) {
				// 각 cell 마다 편집가능 : false - 편집기능 해제

				return false;
			}
		});

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 153, 503, 488);
		rightpanel.add(scrollPane);

		JButton btnNewButton_1 = new JButton("검색");
		btnNewButton_1.setBounds(12, 120, 76, 23);
		rightpanel.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(100, 121, 230, 21);
		rightpanel.add(textField);
		textField.setColumns(10);

		this.table.addMouseListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setVisible(true);

	}

	// 제목줄
	private Vector getColums() {
		Vector column = new Vector();
		column.add("회원번호");
		column.add("회원이름");
		column.add("성별");
		column.add("전화번호");
		column.add("주소");
		column.add("예약시간");
		return column;
	}

// 회원 조회한 데이터 가져오기
	private Vector getDataList() {

		FitnessDao dao = new FitnessDao();
		Vector v = dao.MemberList();

		System.out.println(v);

		return v;
	}

	// 테이블 그리기
	private DefaultTableModel initTable() {
		// 제목줄 처리 : cols
		column = getColums();
		// 데이터 처리 : v
		v = getDataList();
		DefaultTableModel dtm = new DefaultTableModel(v, column);
		return dtm;
	}

	// 회원 정보를 라벨에 넣어서 표시
	public void getLabel(String name, String gender, String tel, String addr, String reserved, String enough) {
		// 이름
		inName = new JLabel(name);
		inName.setBounds(115, 10, 154, 29);
		leftpanel.add(inName);

		// 성별
		inGender = new JLabel(gender);
		inGender.setBounds(115, 60, 207, 29);
		leftpanel.add(inGender);

		// 전화번호
		inTelLabel = new JLabel(tel);
		inTelLabel.setBounds(117, 110, 205, 29);
		leftpanel.add(inTelLabel);

		// 주소
		inAddressLabel = new JLabel(addr);
		inAddressLabel.setBounds(117, 160, 205, 29);
		leftpanel.add(inAddressLabel);

		// 예약시간
		inBookLabel = new JLabel(reserved);
		inBookLabel.setBounds(117, 209, 205, 29);
		leftpanel.add(inBookLabel);

		// 남은일수
		inRemainLabel = new JLabel(enough);
		inRemainLabel.setBounds(117, 260, 205, 29);
		leftpanel.add(inRemainLabel);

	}

	// 라벨청소
	private void clearLabels() {

		// 이름
		inName.setText("");

		// 성별
		inGender.setText("");

		// 전화번호
		inTelLabel.setText("");

		// 주소
		inAddressLabel.setText("");

		// 예약시간
		inBookLabel.setText("");

		// 남은일수
		inRemainLabel.setText("");

	}

	// JTable row 클릭했을 때 회원정보 leftPanel에 나오게
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int r = table.getSelectedRow();
		int c = table.getSelectedColumn();

		String name = (String) table.getValueAt(r, 1); // 클릭한 userid
		String gender = (String) table.getValueAt(r, 2);
		String tel = (String) table.getValueAt(r, 3);
		String addr = (String) table.getValueAt(r, 4);
		String reserved = (String) table.getValueAt(r, 5);
		String enough = "30일";

		leftpanel.repaint();
		getLabel(name, gender, tel, addr, reserved, enough);

		System.out.println(name + " " + gender + " " + tel + " " + addr + " " + reserved + " " + enough);
	}

	// JTable 누를때 라벨 청소 ( 처음 누르면 nullpoint error 나옴 )
	// 초기값을 넣을까...?
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (inName != null)
			clearLabels();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new TrainerMenu();
	}
}
