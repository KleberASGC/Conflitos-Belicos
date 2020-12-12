package ConflitosBelicos;

import java.sql.DriverManager;
import java.sql.Connection;

public class classegenericaconexao {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getConnection();
	}

	public static Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1/aula?useTimezone=true&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null ;
	}
}
