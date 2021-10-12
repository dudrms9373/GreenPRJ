package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static String driver = "org.mariadb.jdbc.Driver";
	private static String url = "jdbc:mariadb://3.34.43.108:3306/member";
	private static String id = "user";
	private static String pwd = "1234";

	private static Connection conn = null;
	
	//기본 생성자
	private DBConn(){}
	
	
	public static Connection getInstance(){
		try {
			if(conn!=null)
				return conn;
			
			Class.forName( driver );
			conn=DriverManager.getConnection( url,id,pwd);
			
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
		return conn;
		
		
	}
}
