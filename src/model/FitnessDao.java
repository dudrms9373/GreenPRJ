package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConn;


public class FitnessDao {
	
	
	// 회원 추가
	public void JoinFitness(FitnessVo FitnessVo) {
		Connection conn;
		PreparedStatement pstmt = null;
		String sql = "";
		
		conn = DBConn.getInstance(); 
		
		sql = "INSERT INTO MEMBER M(m.mem_id,m.mem_name,m.mem_birth,m.id,m.pwd,m.tel,m.gender,m.addr,m.height,m.weight) ";
		sql	+= " VALUES (SEQUENCE1.nextval,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, FitnessVo.getName());
			pstmt.setString(2, FitnessVo.getBirth());
			pstmt.setString(3, FitnessVo.getId());
			pstmt.setString(4, FitnessVo.getPwd());
			pstmt.setString(5, FitnessVo.getTel());
			pstmt.setString(6, FitnessVo.getGender());
			pstmt.setString(7, FitnessVo.getAddress());
			pstmt.setString(8, FitnessVo.getHeight());
			pstmt.setString(9, FitnessVo.getWeight());
			
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

}
