package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import db.DBConn;
import view.UserLoginPage;
import view.UserMenu;


public class FitnessDao {
	static String n1="";
	static String i1="";
	
	
	// CRUD ------------------------------------------------------------------------------------
	//회원 정보 수정
	public void updateMem
			(String id, String name, String pwd ,
					String tel,String addr, String speNote) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql="UPDATE MEMBER AS M, SPECIAL AS S";
		sql		+= " SET M.MEM_NAME= ?";
		sql		+= " ,   M.TEL = ?";
		sql		+= " ,   M.ADDR = ?";
		sql		+= " ,   S.SPE_NOTE = ?";
		sql		+= " WHERE M.ID= ?"
				+ " AND M.ID = S.ID";
		try {
			conn=DBConn.getInstance();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			pstmt.setString(5, speNote);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	//회원 정보 삭제
	public void removeMem(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql="DELETE FROM MEMBER WHERE ID = ?";
		
		try {
			conn=DBConn.getInstance();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
	// 회원조회
	public Vector MemberList() {
		Vector outV = new Vector();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT M.MEM_ID, M.MEM_NAME, M.TEL, M.ADDR, M.GENDER, R.RES_DATE ";
			   sql += " FROM MEMBER M, RESERVATION R ";
			   sql += " WHERE M.MEM_ID = R.MEM_ID ";

		try {
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("MEM_ID"));
				v.add(rs.getString("MEM_NAME"));
				v.add(rs.getString("GENDER"));
				v.add(rs.getString("TEL"));
				v.add(rs.getString("ADDR"));
				v.add(rs.getString("RES_DATE"));
				outV.add(v);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return outV;
	}
	
	// 회원 추가
	public void JoinFitness(MemberVo MemberVo) {
		Connection conn;
		PreparedStatement pstmt = null;
		String sql = "";
		
		conn = DBConn.getInstance(); 
		
		sql = "INSERT INTO MEMBER M(m.mem_id,m.mem_name,m.mem_birth,m.id,m.pwd,m.tel,m.gender,m.addr,m.height,m.weight) ";
		sql	+= " VALUES (SEQUENCE1.nextval,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberVo.getName());
			pstmt.setString(2, MemberVo.getBirth());
			pstmt.setString(3, MemberVo.getId());
			pstmt.setString(4, MemberVo.getPwd());
			pstmt.setString(5, MemberVo.getTel());
			pstmt.setString(6, MemberVo.getGender());
			pstmt.setString(7, MemberVo.getAddress());
			pstmt.setString(8, MemberVo.getHeight());
			pstmt.setString(9, MemberVo.getWeight());
			
			pstmt.executeUpdate();
			
			conn.commit();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 남은기간 연장
	public void prolong(ProlongVo ProlongVo) {

		Connection conn;
		PreparedStatement pstmt = null;
		String sql = "";

		conn = DBConn.getInstance();

		sql = "INSERT INTO PROLONG (PROL_ID,STATUS,START_DATE,END_DATE,PROL_DATE,MEM_ID) ";
		sql += " VALUES (SEQ_PRO.NEXTVAL,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ProlongVo.getStatus());
			pstmt.setString(2, ProlongVo.getStart_date());
			pstmt.setString(3, ProlongVo.getEnd_date());
			pstmt.setString(4, ProlongVo.getProl_date());
			pstmt.setString(5, ProlongVo.getMem_id());

			pstmt.executeUpdate();
			conn.commit();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

	//로그인
	public int loginCheck(String id , String pwd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FitnessVo vo = new FitnessVo();
		String sql = "";
		
		conn= DBConn.getInstance();
		
		sql = "SELECT * FROM MEMBER M";
		sql+= " WHERE M.ID = ? ";
		sql+= " AND   M.PWD = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name =rs.getString(2);
				System.out.println(name+"님 로그인 성공");
				return 1;
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		} 
		return -1;
	}
		
	//로그인 (이름 가져오기)
public String loginCheck1(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FitnessVo vo = new FitnessVo();
		String sql = "";
		String n = "";
		
		conn= DBConn.getInstance();
		
		sql = "SELECT MEM_NAME FROM MEMBER M";
		sql+= " WHERE M.ID = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name =rs.getString(1);
				return name;
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		} 
		return n;
	}
	
	//회원 아이디 찾기(리턴값 = FitnessVo 클래스)
	public FitnessVo IdSearch(String name,String birth,String tel) {
		FitnessVo vo =null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FitnessVo fv = new FitnessVo();
		String sql =" ";
		
		conn = DBConn.getInstance();
		
		sql = "SELECT * FROM MEMBER  ";
		sql+= " WHERE MEM_NAME = ? ";
		sql+= " AND   MEM_BIRTH = ? ";
		sql+= " AND   tel = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, tel);
			
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
			
				String  name1= rs.getString(2);
				String  birth1= rs.getString(3);
				String  id= rs.getString(4);
				String  pwd= rs.getString(5);
				String  tel1= rs.getString(6);
				String  gender= rs.getString(7);
				String  address= rs.getString(8);
				String  height= rs.getString(9);
				String  weight= rs.getString(10);
				
				vo = new FitnessVo(name1, birth1, id, pwd, tel1, gender, address, height, weight);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		} 
		return vo;
	}
	
	//비밀번호 찾기
	public FitnessVo PwdSearch(String name,String birth,String id) {
		FitnessVo vo =null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FitnessVo fv = new FitnessVo();
		String sql =" ";
		
		conn = DBConn.getInstance();
		
		sql = "SELECT * FROM MEMBER  ";
		sql+= " WHERE MEM_NAME = ? ";
		sql+= " AND   MEM_BIRTH = ? ";
		sql+= " AND   ID = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, id);
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
			
				String  name1= rs.getString(2);
				String  birth1= rs.getString(3);
				String  id1= rs.getString(4);
				String  pwd= rs.getString(5);
				String  tel1= rs.getString(6);
				String  gender= rs.getString(7);
				String  address= rs.getString(8);
				String  height= rs.getString(9);
				String  weight= rs.getString(10);
				
				vo = new FitnessVo(name1, birth1, id1, pwd, tel1, gender, address, height, weight);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		} 
		return vo;
	}
	// 예약하기 (결과 메시지 )
		public String reserve(ReservationVo resVo){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String result = "예약에 실패했습니다";
			String msg="";
			String sql = "INSERT INTO RESERVATION(RES_ID ,RES_DATE, RES_NOTE, RES_CHECK, MEM_ID, T_ID)";
			sql   	  += " VALUES (SEQ_RES.NEXTVAL ,? , ? , ? , ? , ? )";
			
			try {
				conn=DBConn.getInstance();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, resVo.getResDate());
				pstmt.setString(2, resVo.getResNote());
				pstmt.setString(3, resVo.getResCheck());
				pstmt.setInt(4, resVo.getResMemId());
				pstmt.setInt(5, resVo.getResTId());
				
				pstmt.executeUpdate();
				if(resVo.getResCheck().equals("P")){
					msg = "PT";
				}
				if(resVo.getResCheck().equals("C")){
					msg = "상담";
				}
				
				result = resVo.getResNote()+"에 "+msg+"가 예약되었습니다";
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if( rs    != null )  rs.close();
					if( pstmt != null )  pstmt.close();
				} catch (SQLException e) {
				}
			} 

			return result;

		}
	
	//특이사항 추가
	public String writeSpe(SpecialVo speVo){
		
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		String result = "특이사항 추가 실패";

		String sql="INSERT INTO SPECIAL(SPE_ID, SPE_NOTE, MEM_ID)";
		sql	 +=" VALUES (SEQ_SPE.NEXTVAL, ? , ? )";
		
		try {
			conn=DBConn.getInstance();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, speVo.getSpeNote());
			pstmt.setInt(2, speVo.getSpeMemId());
			pstmt.executeUpdate();
			
			result= "특이사항이 추가되었습니다";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
		
	
	
		}
	
	



