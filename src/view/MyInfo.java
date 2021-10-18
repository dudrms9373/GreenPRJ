public class MyInfo extends JFrame implements ActionListener {

	JButton JbPreView, Jbfire, JbProlong, JbCancel;

	JLabel lblMyInfo, lblName, lblTel, lblAddr, lblRemainDay, lblPtTime, lblMyName, lblMyTel, lblMyAddr, lblMyReaminDay,
			lblMyPtTime, lblMyWeight, lblMyHeight, lblHeight, lblWeight;

	private String id = "";
	private String name = "";

	public MyInfo(String name, String id) {

		FitnessDao dao = new FitnessDao();

		this.id = id;
		this.name = name;

		this.setTitle("내 정보");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		this.setSize(600, 500);

		// 이전 버튼
		JbPreView = new JButton("<이전");
		JbPreView.setBackground(Color.WHITE);
		JbPreView.setBounds(12, 10, 85, 23);

		// 내 정보 label (맨 위)
		lblMyInfo = new JLabel("내 정보");
		lblMyInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyInfo.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lblMyInfo.setBounds(132, 10, 275, 90);

		// 이름 label
		lblName = new JLabel("이름");
		lblName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(69, 82, 171, 29);

		// 전화번호 label
		lblTel = new JLabel("전화번호");
		lblTel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel.setBounds(79, 121, 171, 29);

		// 주소 label
		lblAddr = new JLabel("주소");
		lblAddr.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddr.setBounds(69, 159, 171, 29);

		// 남은 횟수 label
		lblRemainDay = new JLabel("남은횟수");
		lblRemainDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemainDay.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRemainDay.setBounds(69, 293, 171, 29);

		// 예약시간 label
		lblPtTime = new JLabel("PT 예약 시간");
		lblPtTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblPtTime.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPtTime.setBounds(69, 348, 171, 29);

		// 회원탈퇴 버튼
		Jbfire = new JButton("회원탈퇴");
		Jbfire.setForeground(Color.BLACK);
		Jbfire.setBackground(Color.DARK_GRAY);
		Jbfire.setFont(new Font("굴림", Font.PLAIN, 10));
		Jbfire.setBounds(401, 405, 85, 23);


		// 연장하기 버튼
		JbProlong = new JButton("연장하기");
		JbProlong.setBounds(382, 299, 85, 23);

		
		
		// 데이터넣기이이이잉
		
		MemberVo mv = dao.getMemInfo(id);

		String tel = mv.getTel();
		String addr = mv.getAddress();
		String remainNum = mv.getRemainNum();
		String ptTime = mv.getPtTime();
		String height = mv.getHeight();
		String weight = mv.getWeight();

		setLabel(name, tel, addr, remainNum, ptTime, height, weight);
		

		// 나의 남은 횟 수
		// lblMyReaminDay = new JLabel("OO일");
		lblMyReaminDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyReaminDay.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyReaminDay.setBounds(262, 293, 149, 32);
		
		// 내 이름
		// lblMyName = new JLabel("OOO");
		lblMyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyName.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyName.setBounds(279, 87, 149, 32);

		// 내 전화번호
		// lblMyTel = new JLabel("000-0000-0000");
		lblMyTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyTel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyTel.setBounds(289, 121, 149, 32);

		// 내 주소
		// lblMyAddr = new JLabel("부산광역시");
		lblMyAddr.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyAddr.setBounds(279, 159, 149, 32);

		// 내 PT 예약시간
		// lblMyPtTime = new JLabel("2021-10-20 AM 00:00");
		lblMyPtTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyPtTime.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyPtTime.setBounds(252, 348, 149, 32);

		// 버튼 및 Label 추가
		getContentPane().add(JbPreView);
		getContentPane().add(JbProlong);
		getContentPane().add(Jbfire);

		getContentPane().add(lblName);
		getContentPane().add(lblTel);
		getContentPane().add(lblAddr);
		getContentPane().add(lblRemainDay);
		getContentPane().add(lblPtTime);

		getContentPane().add(lblMyAddr);
		getContentPane().add(lblMyInfo);
		getContentPane().add(lblMyName);
		getContentPane().add(lblMyPtTime);
		getContentPane().add(lblMyReaminDay);
		getContentPane().add(lblMyTel);

		JbCancel = new JButton("예약변경");
		JbCancel.setBounds(401, 354, 85, 23);
		getContentPane().add(JbCancel);

		lblHeight = new JLabel("키");
		lblHeight.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setBounds(69, 202, 171, 29);
		getContentPane().add(lblHeight);

		lblWeight = new JLabel("몸무게");
		lblWeight.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setBounds(69, 241, 171, 29);
		getContentPane().add(lblWeight);

		// lblMyHeight = new JLabel("170");
		lblMyHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyHeight.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyHeight.setBounds(279, 202, 149, 32);
		getContentPane().add(lblMyHeight);

		// lblMyWeight = new JLabel("72");
		lblMyWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyWeight.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyWeight.setBounds(279, 241, 149, 32);
		getContentPane().add(lblMyWeight);

		this.JbPreView.addActionListener(this);
		this.JbProlong.addActionListener(this);
		this.Jbfire.addActionListener(this);



	}
		public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "<이전":
			new UserMenu(name, id);
			break;
		case "회원탈퇴":
			new UserFire(id);
			break;
		case "연장하기":
			new PTPrice(id);
			break;
		}
	}
		public void setLabel(String name, String tel, String addr, String remainNum, String ptTime, String height,
			String weight) {

		lblMyName.setText(name);
		lblMyAddr.setText(addr);
		lblMyPtTime.setText(ptTime);
		lblMyReaminDay.setText(remainNum);
		lblMyTel.setText(tel);
		lblMyHeight.setText(height);
		lblMyWeight.setText(weight);

	}
	
//	public static void main(String[] args) {
//		new MyInfo();
//	}

}
