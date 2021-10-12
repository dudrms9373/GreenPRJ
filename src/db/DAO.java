package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
		private String driver = "org.mariadb.jdbc.Driver";
		private String url = "jdbc:mariadb://3.34.43.108:3306/member"; // 현재 작동 안함. 나중에 프로젝트 시작하면 다시 만들어서 연결 하겠습니다.
		private String id = "user";
		private String pwd = "1234";

		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
	// 생성자
	public DAO(){ // main함수안에서 작성되었기에 수정함
		open();
	}
	
	
	private void open(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			if (conn != null) {
				System.out.println("DB 접속 성공");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}

}
