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
	

}
