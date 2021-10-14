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

	// 예약하기 (결과 메시지 )
	public String reserve(ReservationVo resVo){
		String result = "예약에 실패했습니다";
		String msg="";
		String sql = "INSERT INTO RESERVATION(RES_ID ,RES_DATE, RES_NOTE, RES_CHECK, MEM_ID, T_ID)";
		sql   	  += " VALUES (SEQ_RES ,? , ? , ? , ? , ? )";
		
		try {
			conn=DBConn.getInstance();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, resVo.getResDate());
			pstmt.setString(2, resVo.getResNote());
			pstmt.setString(3, resVo.getResCheck());
			pstmt.setString(4, resVo.getResMemId());
			pstmt.setString(5, resVo.getResTId());
			
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
		} finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
	 

		return result;

	}
	
	}
	
	
}
