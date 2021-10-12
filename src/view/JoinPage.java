package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class JoinPage extends JFrame{
	
	JPanel           p;
	JTextField          TextFieldID, TextFieldName, TextFieldBirth, TextFieldPWD, 
	                    TextFieldTel, TextFieldGender, TextFieldAddres;
	JPasswordField      PasswordFieldPWD;
	JTextArea           taIntro;
	JButton             ButtonAdd, ButtonCancel;

	GridBagLayout       gb;
	GridBagConstraints  gbc;   // option 
	public JoinPage() {
		this.setTitle("회원가입");
		
		gb      =  new GridBagLayout();
	      this.setLayout( gb );
	      
	      gbc          =  new GridBagConstraints();
	      gbc.fill     =  GridBagConstraints.BOTH;
	      gbc.weightx  = 1.0;
	      gbc.weighty  = 1.0;
	      
	      // 이름
	      JLabel   LabelName   =  new JLabel("아이디"); 
	      TextFieldName             =  new JTextField(20);
	      gbAdd( LabelName, 0, 0, 1, 1);
	      gbAdd( TextFieldName,  1, 0, 3, 1);
	      
	      // 생년월일
	      JLabel  LabelBirth  =  new  JLabel("생년월일");
	      TextFieldBirth      =  new  JPasswordField( 20 );
	      gbAdd( LabelBirth, 0, 1, 1, 1);
	      gbAdd( TextFieldBirth,  1, 1, 3, 1);
	                  
	      // ID
	      JLabel  LabelID  =  new  JLabel("ID");
	      TextFieldID           =  new  JTextField(20);
	      gbAdd( LabelID, 0, 2, 1, 1);
	      gbAdd( TextFieldID,  1, 2, 3, 1);
	      
	      // PWD
	      JLabel  LabelPWD  =  new  JLabel("PWD");
	      TextFieldPWD           =  new  JTextField(20);
	      gbAdd( LabelPWD, 0, 3, 1, 1);
	      gbAdd( TextFieldPWD,  1, 3, 3, 1);
	      
	      // 전화번호
	      JLabel  LableTel  =  new  JLabel("전화번호");
	      TextFieldTel           =  new  JTextField(20);
	      gbAdd( LableTel, 0, 4, 1, 1);
	      gbAdd( TextFieldTel,  1, 4, 3, 1);
	     
	      // 성별
	      JLabel  LableGender  =  new  JLabel("성별");
	      TextFieldGender           =  new  JTextField(20);
	      gbAdd( LableGender, 0, 5, 1, 1);
	      gbAdd( TextFieldGender,  1, 5, 3, 1);
	      
	      // 주소(~동 까지)
	      JLabel  LabelAddres  =  new  JLabel("주소(~동 까지)");
	      TextFieldAddres           =  new  JTextField(20);
	      gbAdd( LabelAddres, 0, 6, 1, 1);
	      gbAdd( TextFieldAddres,  1, 6, 3, 1);
	      
	      //버튼(가입,취소)
	      ButtonAdd = new JButton("가입");
	      ButtonCancel= new JButton("취소");
	      gbAdd( ButtonAdd, 0, 7, 2, 1);
	      gbAdd( ButtonCancel,  1, 7, 2, 1);
		
	      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      this.setSize( 350, 600 );
	      this.setLocationRelativeTo(null);
	      this.setVisible(true);
		
		
	}
	private void gbAdd(JComponent c, int x, int y, int w, int h) {
	      gbc.gridx       =  x;  
	      gbc.gridy       =  y;
	      gbc.gridwidth   =  w; 
	      gbc.gridheight  =  h;
	      gb.setConstraints(c, gbc);
	      gbc.insets      =  new Insets(2, 2, 2, 2);
	      this.add(c, gbc);
	      
	   }
	
	public static void main(String[] args) {
	      new JoinPage();
	   }
	

}
