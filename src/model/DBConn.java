package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private  static  String  driver = "oracle.jdbc.OracleDriver";
	private  static  String  url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "spring08";
	private static String pwd = "spring08";

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
