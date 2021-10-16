package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyInfo extends JFrame {

	JButton JbPreView, JbWidthDraw, JbProlong;

	JLabel lblMyInfo, lblName, lblTel, lblAddr, lblRemainDay, lblPtTime, 
	       lblMyName, lblMyTel, lblMyAddr, lblMyReaminDay, lblMyPtTime;
		

	public MyInfo() {

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

		// 남은 일수 label
		lblRemainDay = new JLabel("남은일수");
		lblRemainDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemainDay.setFont(new Font("Dialog", Font.BOLD, 20));
		lblRemainDay.setBounds(69, 293, 171, 29);

		// 예약시간 label
		lblPtTime = new JLabel("PT 예약 시간");
		lblPtTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblPtTime.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPtTime.setBounds(69, 348, 171, 29);

		// 회원탈퇴 버튼
		JbWidthDraw = new JButton("회원탈퇴");
		JbWidthDraw.setForeground(Color.BLACK);
		JbWidthDraw.setBackground(Color.DARK_GRAY);
		JbWidthDraw.setFont(new Font("굴림", Font.PLAIN, 10));
		JbWidthDraw.setBounds(401, 405, 85, 23);

		// 나의 남은 일 수
		lblMyReaminDay = new JLabel("OO일");
		lblMyReaminDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyReaminDay.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyReaminDay.setBounds(262, 293, 149, 32);

		// 연장하기 버튼
		JbProlong = new JButton("연장하기");
		JbProlong.setBounds(382, 299, 85, 23);

		// 내 이름
		lblMyName = new JLabel("OOO");
		lblMyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyName.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyName.setBounds(279, 87, 149, 32);

		// 내 전화번호
		lblMyTel = new JLabel("000-0000-0000");
		lblMyTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyTel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyTel.setBounds(289, 121, 149, 32);

		// 내 주소
		lblMyAddr = new JLabel("부산광역시");
		lblMyAddr.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyAddr.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyAddr.setBounds(279, 159, 149, 32);

		// 내 PT 예약시간
		lblMyPtTime = new JLabel("2021-10-20 AM 00:00");
		lblMyPtTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyPtTime.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyPtTime.setBounds(252, 348, 149, 32);

		// 버튼 및 Label 추가
		getContentPane().add(JbPreView);
		getContentPane().add(JbProlong);
		getContentPane().add(JbWidthDraw);

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

		JButton JbCancel = new JButton("예약변경");
		JbCancel.setBounds(401, 354, 85, 23);
		getContentPane().add(JbCancel);

		JLabel lblHeight = new JLabel("키");
		lblHeight.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setBounds(69, 202, 171, 29);
		getContentPane().add(lblHeight);

		JLabel lblWeight = new JLabel("몸무게");
		lblWeight.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setBounds(69, 241, 171, 29);
		getContentPane().add(lblWeight);

		JLabel lblMyHeight = new JLabel("170");
		lblMyHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyHeight.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyHeight.setBounds(279, 202, 149, 32);
		getContentPane().add(lblMyHeight);

		JLabel lblMyWeight = new JLabel("72");
		lblMyWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyWeight.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblMyWeight.setBounds(279, 241, 149, 32);
		getContentPane().add(lblMyWeight);

	}
	
//	public static void main(String[] args) {
//		new MyInfo();
//	}

}
