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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.FitnessDao;

public class TrainerMenu extends JFrame implements ActionListener, MouseListener {

	private JTextField textField;
	JPanel leftpanel, rightpanel;
	JLabel inName, inGender, inTelLabel, inAddressLabel, inBookLabel, inRemainLabel;
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel dtm;
	Vector v;
	Vector column;
	JTextArea specTextArea,PtTextArea;

	public TrainerMenu() {
		this.setTitle("트레이너 화면");

		leftpanel = new JPanel();
		leftpanel.setBounds(0, 0, 356, 651);
		getContentPane().add(leftpanel);
		leftpanel.setLayout(null);
		// 이름
		inName = new JLabel("사용자 이름 넣는곳");
		inName.setBounds(121, 22, 207, 29);
		leftpanel.add(inName);

		// 성별
		inGender = new JLabel("성별 들어갈곳");
		inGender.setBounds(121, 72, 207, 29);
		leftpanel.add(inGender);

		// 전화번호
		inTelLabel = new JLabel("전화 번호 넣는곳");
		inTelLabel.setBounds(123, 122, 205, 29);
		leftpanel.add(inTelLabel);

		// 주소
		inAddressLabel = new JLabel("부산 광역시 대연동");
		inAddressLabel.setToolTipText(inAddressLabel.getText());
		inAddressLabel.setBounds(123, 172, 205, 29);
		leftpanel.add(inAddressLabel);

		// 예약시간
		inBookLabel = new JLabel("예약시간 넣는곳");
		inBookLabel.setBounds(123, 222, 205, 29);
		leftpanel.add(inBookLabel);

		// 남은일수
		inRemainLabel = new JLabel("남은 일 수 넣는곳");
		inRemainLabel.setBounds(123, 272, 205, 29);
		leftpanel.add(inRemainLabel);

		JLabel NameLabel = new JLabel("회원 이름     : ");
		NameLabel.setBounds(20, 22, 82, 29);
		leftpanel.add(NameLabel);

		JLabel genderLabel = new JLabel("성별              : ");
		genderLabel.setBounds(20, 72, 82, 29);
		leftpanel.add(genderLabel);

		JLabel telLabel = new JLabel("전화번호      :");
		telLabel.setBounds(20, 122, 82, 29);
		leftpanel.add(telLabel);

		JLabel addressLabel = new JLabel("주소              : ");
		addressLabel.setBounds(20, 172, 82, 29);
		leftpanel.add(addressLabel);

		JLabel bookLabel = new JLabel("예약 시간     : ");
		bookLabel.setBounds(20, 222, 82, 29);
		leftpanel.add(bookLabel);

		JLabel remainLabel = new JLabel("남은 일 수    :");
		remainLabel.setBounds(20, 272, 82, 29);
		leftpanel.add(remainLabel);

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

		//JScrollPane
				specTextArea= new JTextArea();
				PtTextArea = new JTextArea();
				JScrollPane spScroll = new JScrollPane(specTextArea);
				JScrollPane ptScroll = new JScrollPane(PtTextArea);
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(14, 338, 340, 260);
				leftpanel.add(tabbedPane);
				
				tabbedPane.addTab("특이사항", spScroll );
				tabbedPane.addTab("PT 내역", ptScroll );
				
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
	public void getLabel(String name, String gender, String tel, 
			             String addr, String reserved, String enough) {
		
				// 이름
				inName.setText(name);

				// 성별
				inGender.setText(gender);

				// 전화번호
				inTelLabel.setText(tel);

				// 주소
				inAddressLabel.setText(addr);

				// 예약시간
				inBookLabel.setText(reserved);

				// 남은횟수
				inRemainLabel.setText(enough);

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

		//특이사항
		specTextArea.setText("");
		
		//PT내역
		PtTextArea.setText("");
	}

	// JTable row 클릭했을 때 회원정보 leftPanel에 나오게
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			FitnessDao dao = new FitnessDao();
			
			int r = table.getSelectedRow();
			int c = table.getSelectedColumn();
			
			
			String memid = (String) table.getValueAt(r, 0);
			String name = (String) table.getValueAt(r, 1);
			String gender = (String) table.getValueAt(r, 2);
			String tel = (String) table.getValueAt(r, 3);
			String addr = (String) table.getValueAt(r, 4);
			String reserved = (String) table.getValueAt(r, 5);
			String enough = "30 회";

			leftpanel.repaint();
			getLabel(name, gender, tel, addr, reserved, enough);

			//특이사항 메소드 연결
			specTextArea.setText(dao.specialMem(memid));
			
			//PT 내역사항 메소드랑 연결해야함!!!! --  2021.10.17
			//PtTextArea.setText();

			System.out.println(name + " " + gender + " " + tel + " " + addr + " " + reserved + " " + enough);
		}
	// JTable 누를때 라벨 청소
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
