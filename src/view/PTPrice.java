package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Font;

public class PTPrice extends JFrame implements ActionListener{
	JButton extension;
	JRadioButton w6,w15,w24,w36;
	ButtonGroup bg;
	private String id = "";

	public PTPrice(String id) {
		
		this.id = id;
		this.setTitle("남은 기간 연장");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,460);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel month_1 = new JLabel("PT 10회");
		month_1.setHorizontalAlignment(SwingConstants.CENTER);
		month_1.setFont(new Font("굴림", Font.BOLD, 16));
		month_1.setBounds(58, 35, 89, 30);
		getContentPane().add(month_1);
		
		JLabel month_3 = new JLabel("PT 30회");
		month_3.setFont(new Font("굴림", Font.BOLD, 16));
		month_3.setHorizontalAlignment(SwingConstants.CENTER);
		month_3.setBounds(58, 105, 89, 30);
		getContentPane().add(month_3);
		
		JLabel month_6 = new JLabel("PT 60회");
		month_6.setHorizontalAlignment(SwingConstants.CENTER);
		month_6.setFont(new Font("굴림", Font.BOLD, 16));
		month_6.setBounds(58, 175, 89, 30);
		getContentPane().add(month_6);
		
		JLabel month_12 = new JLabel("PT 120회");
		month_12.setFont(new Font("굴림", Font.BOLD, 16));
		month_12.setHorizontalAlignment(SwingConstants.CENTER);
		month_12.setBounds(58, 245, 89, 30);
		getContentPane().add(month_12);
		
		extension = new JButton("연장하기");
		extension.setBounds(106, 328, 157, 50);
		getContentPane().add(extension);
		
		bg = new ButtonGroup();
		
		w6 = new JRadioButton("500,000원");
		w6.setFont(new Font("굴림", Font.BOLD, 14));
		w6.setBounds(204, 35, 121, 30);
		getContentPane().add(w6);
		
		w15 = new JRadioButton("1,000,000원");
		w15.setFont(new Font("굴림", Font.BOLD, 14));
		w15.setBounds(204, 105, 121, 30);
		getContentPane().add(w15);
		
		w24 = new JRadioButton("2,400,000원");
		w24.setFont(new Font("굴림", Font.BOLD, 14));
		w24.setBounds(204, 175, 121, 30);
		getContentPane().add(w24);
		
		w36 = new JRadioButton("3,600,000원");
		w36.setFont(new Font("굴림", Font.BOLD, 14));
		w36.setBounds(204, 245, 121, 30);
		getContentPane().add(w36);
		
		bg.add(w6);
		bg.add(w15);
		bg.add(w24);
		bg.add(w36);
		
		this.extension.addActionListener(this);
		this.w6.addActionListener(this);
		this.w15.addActionListener(this);
		this.w24.addActionListener(this);
		this.w36.addActionListener(this);
		
		this.setVisible(true);
	}
	
//	public static void main(String[] args) {
//		new PTPrice();
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int num ;
		if( e.getActionCommand().equals("500,000원") ) {
		System.out.println("PT 10회");
		num = 10;
		}
		else if( e.getSource() == w15 ) {
			System.out.println("PT 30회");
			num = 30;
		}
		else if( e.getSource()== w24 ) {
			System.out.println("PT 60회");
			num = 60;
		}
		else if( e.getSource() ==w36 ) {
			System.out.println("PT 120회");
			num = 120;
		}else {
			JOptionPane.showMessageDialog(null, "선택해주세요");
		}
			
	}
}
