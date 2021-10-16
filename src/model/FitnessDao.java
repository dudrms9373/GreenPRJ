package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class FitnessDao {
	static String n1 = "";
	static String i1 = "";
	ResultSet rs = null;
	

	// CRUD
	// ------------------------------------------------------------------------------------
	// 회원 정보 수정
	public void updateMem(String id, String name, String pwd, String tel, String addr, String speNote) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		

		String sql = "UPDATE MEMBER AS M, SPECIAL AS S";
		sql += " SET M.MEM_NAME= ?";
		sql += " ,   M.TEL = ?";
		sql += " ,   M.ADDR = ?";
		sql += " ,   S.SPE_NOTE = ?";
		sql += " WHERE M.ID= ?" + " AND M.ID = S.ID";
		try {
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
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
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// 회원 정보 삭제 ( 점검 완료)
	public String removeMem(String id) {
		String result="삭제에 실패했습니다";
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = DBConn.getInstance();
		String sql = "DELETE  FROM  MEMBER ";
		sql		  += " WHERE ID = ?";
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			result=id+"계정이 삭제되었습니다";

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
		return result;
	}


	// 회원조회
	public Vector MemberList() {
		Vector outV = new Vector();

		Connection conn = null;
		PreparedStatement pstmt = null;

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
	
	//특이사항 가져오기
		public String specialMem(String memId) {

			Connection conn = null;
			PreparedStatement pstmt = null;
			String note = "";
			String sql = "SELECT SPE_NOTE ";
			sql += " FROM SPECIAL S ";
			sql += " WHERE S.MEM_ID = ? ";

			try {
				conn = DBConn.getInstance();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, memId);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					note = rs.getString("SPE_NOTE");
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
			return note;
		}
		

	// 회원 추가
	public int JoinFitness(MemberVo MemberVo) {
		Connection conn;
		PreparedStatement pstmt = null;
		String sql = "";

		conn = DBConn.getInstance();

		sql      = "INSERT INTO MEMBER(MEM_ID, MEM_NAME, MEM_BIRTH,";
		sql		+= " ID, PWD, TEL, GENDER, ADDR, HEIGHT, WEIGHT)";
		sql		+= " VALUES (SEQ_MEM.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

		} catch (SQLIntegrityConstraintViolationException e) {
			
			System.out.println("아이디가 중복되었습니다");
			
			
			return -1;
		}
		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	/* 10/15 Prolong 테이블 삭제함 수정 필요 ( 김영근 )
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
	*/
	

	// 로그인
	public int loginCheck(String id, String pwd) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = new MemberVo();
		String sql = "";

		conn = DBConn.getInstance();

		sql = "SELECT * FROM MEMBER M";
		sql += " WHERE M.ID = ? ";
		sql += " AND   M.PWD = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString(2);
				System.out.println(name + "님 로그인 성공");
				return 1;
			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return -1;
	}

	// 로그인 (이름 가져오기)
	public String loginCheck1(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = new MemberVo();
		String sql = "";
		String n = "";

		conn = DBConn.getInstance();

		sql = "SELECT MEM_NAME FROM MEMBER M";
		sql += " WHERE M.ID = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString(1);
				return name;
			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return n;
	}

	// 회원 아이디 찾기(리턴값 = FitnessVo 클래스)
	public MemberVo IdSearch(String name, String birth, String tel) {
		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo fv = new MemberVo();
		String sql = " ";

		conn = DBConn.getInstance();

		sql = "SELECT * FROM MEMBER  ";
		sql += " WHERE MEM_NAME = ? ";
		sql += " AND   MEM_BIRTH = ? ";
		sql += " AND   tel = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, tel);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String name1 = rs.getString(2);
				String birth1 = rs.getString(3);
				String id = rs.getString(4);
				String pwd = rs.getString(5);
				String tel1 = rs.getString(6);
				String gender = rs.getString(7);
				String address = rs.getString(8);
				String height = rs.getString(9);
				String weight = rs.getString(10);

				vo = new MemberVo(name1, birth1, id, pwd, tel1, gender, address, height, weight);

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
		return vo;
	}

	// 비밀번호 찾기
	public MemberVo PwdSearch(String name, String birth, String id) {
		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo fv = new MemberVo();
		String sql = " ";

		conn = DBConn.getInstance();

		sql = "SELECT * FROM MEMBER  ";
		sql += " WHERE MEM_NAME = ? ";
		sql += " AND   MEM_BIRTH = ? ";
		sql += " AND   ID = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String name1 = rs.getString(2);
				String birth1 = rs.getString(3);
				String id1 = rs.getString(4);
				String pwd = rs.getString(5);
				String tel1 = rs.getString(6);
				String gender = rs.getString(7);
				String address = rs.getString(8);
				String height = rs.getString(9);
				String weight = rs.getString(10);

				vo = new MemberVo(name1, birth1, id1, pwd, tel1, gender, address, height, weight);

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
		return vo;
	}
	//비밀번호 변경
	public void newPwd(String pwd,String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		String sql ="";
		
		conn = DBConn.getInstance();
		
		sql  = " UPDATE MEMBER SET pwd = ?";
		sql  += " WHERE id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);
			
			pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {
			try {
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		} 
	}

	// 예약하기 (결과 메시지 )
	public String reserve(ReservationVo resVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "예약에 실패했습니다";
		String msg = "";
		String sql = "INSERT INTO RESERVATION(RES_ID ,RES_DATE, RES_NOTE, MEM_ID, T_ID)";
		sql += " VALUES (SEQ_RES.NEXTVAL ,? , ? , ? , ? , ? )";

		try {
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resVo.getResDate());
			pstmt.setString(2, resVo.getResNote());
			pstmt.setInt(3, resVo.getResMemId());
			pstmt.setInt(4, resVo.getResTId());

			pstmt.executeUpdate();
			

			result = resVo.getResNote() + "에 PT가 예약되었습니다";
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

		return result;

	}

	// 특이사항 추가
	public String writeSpe(SpecialVo speVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String result = "특이사항 추가 실패";

		String sql = "INSERT INTO SPECIAL(SPE_ID, SPE_NOTE, MEM_ID)";
		sql += " VALUES (SEQ_SPE.NEXTVAL, ? , ? )";

		try {
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, speVo.getSpeNote());
			pstmt.setInt(2, speVo.getSpeMemId());
			pstmt.executeUpdate();

			result = "특이사항이 추가되었습니다";
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

		return result;
	}

	// PT 내역 추가( sql 에러가 뜨는 걸 보니 괜찮음. 테스트는 reservation에 있는 데이터의 추가가 아니면 안됨)
	public String writeExe(ExecutionVo exeVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String result = "PT 내역 추가 실패";

		String sql = "INSERT INTO EXECUTION(EXE_ID, EXE_NOTE,";
		sql += " HEIGHT, WEIGHT, REMAIN_NUM, RES_ID )";
		sql += " VALUES ( SEQ_EXE.NEXTVAL, ? , ? , ? , ? , ? )";
		conn = DBConn.getInstance();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, exeVo.getExeNote());
			pstmt.setInt(2, exeVo.getHeight());
			pstmt.setInt(3, exeVo.getWeight());
			pstmt.setInt(4, exeVo.getRemainNum());  // 새 테이블에 맞춰 수정됨
			pstmt.setInt(5, exeVo.getResId());

			pstmt.executeUpdate();

			result = "PT 내역 추가되었습니다.";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

			return result;

		}

	}

	// Id 기준 실행 내역 전체 조회(Vector)
	public Vector getExeInfo(String Id, String exeCheck) {
		Vector outV = new Vector();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT  E.EXE_ID,  E.EXE_NOTE, E.HEIGHT, E.WEIGHT,  ";
		sql += " E.EXE_CHECK, TO_CHAR(R.RES_DATE, 'YYYY-MM-DD') RES_DATE  ";
		sql += " FROM   EXECUTION E, RESERVATION R, MEMBER M   ";
		sql += " WHERE R.MEM_ID = M.MEM_ID";
		sql += " AND R.RES_ID = E.RES_ID";
		sql += " AND M.ID = ? AND E.EXE_CHECK= ?";

		try {
			conn = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				Vector v = new Vector();
				v.add(rs.getInt("EXE_ID"));
				v.add(rs.getString("EXE_NOTE"));
				v.add(rs.getInt("HEIGHT"));
				v.add(rs.getInt("WEIGHT"));
				v.add(rs.getString("EXE_CHECK"));
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
	
	// 예약 변경 메소드(update set으로 기존 정보만 변경)
	public String updateRes(ReservationVo resVo1 ,ReservationVo resVo2) {
		String result="예약 변경에 실패하였습니다";

		Connection conn         = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE RESERVATION";
		sql       += " SET RES_DATE   = ?,";
		sql	  	  += " RES_NOTE       = ?,";
		sql	      += " T_ID 	      = ? ";
		sql	      += " WHERE RES_DATE = ? ";

		try {
			conn = DBConn.getInstance();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, resVo2.getResDate());
			pstmt.setString(2, resVo2.getResNote());
			pstmt.setInt(3, resVo2.getResTId());
			pstmt.setString(4, resVo1.getResDate());
			pstmt.executeUpdate();
			
			result=resVo2.getResDate()+"로 예약이 변경되었습니다";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null )  pstmt.close();
			} catch (SQLException e) {
			}
		} 

		return result;
		
	}
	
	//회원 번호로 예약 취소하기
	public void removeRes(int resMemId) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		
		
		String sql= "DELETE FROM RESERVATION WHERE MEM_ID= ?";
		try {
			conn= DBConn.getInstance();
			pstmt= conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}	
	}
	
	// 회원 개인 정보 조회( 점검 완료 ) -- 내 정보 창에 나오는 정보 위주
	public MemberVo getMemInfo(String id) {
		MemberVo memVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql= "SELECT  MEM_NAME, TEL, GENDER, ADDR, HEIGHT, WEIGHT";
		sql		 += " FROM MEMBER";
		sql	 	 += " WHERE ID = ?";
				
		try {
			conn  = DBConn.getInstance();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs    = pstmt.executeQuery();
			if(rs.next()) {
				String name   = rs.getString("MEM_NAME");
				String tel    = rs.getString("TEL");
				String gender = rs.getString("GENDER");
				String addr   = rs.getString("ADDR");
				String height    = rs.getString("HEIGHT");
				String weight    = rs.getString("WEIGHT");
				
				memVo 		  = new MemberVo(height, weight, name,
						tel, gender, addr); // 생성자 새로 생성했음 - 김영근
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		return memVo;
		
	}
	
	
	//회수 연장 메소드
	public String addNum(String id, int num){
		String result = "회수 연장에 실패했습니다";
		
		Connection conn = null;	
		PreparedStatement pstmt = null;
		
		int memId = getMemId(id);
		
		String sql = "UPDATE EXECUTION";
		sql		  += " SET REMAIN_NUM = REMAIN_NUM + ?";
		sql		  += " WHERE MEM_ID = ? ";
		
		try {
			conn=DBConn.getInstance();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, memId);
			pstmt.executeUpdate();
			
			result= "회수가 "+num+"회 연장되었습니다";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//id를 받아 회원번호를 가져오는 메소드
	private int getMemId(String id) {
		int memId = 0;
		Connection conn = null;	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT MEM_ID";
		sql		  += " FROM MEMBER";
		sql		  += " WHERE ID = ? ";
		
		
			conn=DBConn.getInstance();
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				if( rs.next() ){
					memId = rs.getInt("MEM_ID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
					try {
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		
		
		
		return memId;	
	}
		
		
	

}
