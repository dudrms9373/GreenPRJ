package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
		

		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
	// 생성자
	public DAO(){ 
	
	}
	
	// CRUD ------------------------------------------------------------------------------------
	//회원 정보 수정
	public void updateMem
			(String id, String name, String pwd ,
					String tel,String addr, String speNote) {
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
	
		
  // 추가
	public void insertMember(String name, String birth, String id, String pwd, String tel, String gender,
							 String addr, double height, double weight) {

		String sql = "INSERT INTO MEMBER VALUES (NVL(MAX(MEM_ID),0)+1, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, id);
			pstmt.setString(4, pwd);
			pstmt.setString(5, tel);
			pstmt.setString(6, gender);
			pstmt.setString(7, addr);
			pstmt.setDouble(8, height);
			pstmt.setDouble(9, weight);

			pstmt.executeUpdate();

			System.out.println("추가 완료");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 조회
	public Vector MemberList() {
		Vector  outV   = new Vector();
		
		Connection         conn   = null;
		PreparedStatement  pstmt  = null;
		ResultSet          rs     = null;
		
		String sql = "SELECT M.MEM_ID, M.MEM_NAME, M.TEL, M.ADDR, M.GENDER, R.RES_DATE";
				sql += " FROM MEMBER M, RESERVATION R";
				sql += " WHERE M.MEM_ID = R.MEM_ID" ;
		
		try {
			conn      =  DBConn.getInstance();
			pstmt     =  conn.prepareStatement(sql);
			rs  =  pstmt.executeQuery();
			
			while( rs.next() ) {
				Vector    v  =   new  Vector(); 
				v.add( rs.getString("MEM_ID") );
				v.add( rs.getString("MEM_NAME") ); 
				v.add( rs.getString("GENDER") ); 
				v.add( rs.getString("TEL") ); 
				v.add( rs.getString("ADDR") );
				outV.add( v );							
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		} 
		return   outV;
	}

}
