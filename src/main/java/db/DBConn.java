package db;

import java.sql.Connection;
import java.sql.DriverManager;

/* 오라클을 연결하고 최종적으로 Connection 객체를 반환하는 역활 */
public class DBConn{
	  String driver = "oracle.jdbc.driver.OracleDriver";
	  String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	  String user = "C##KIM";
	  String pwd = "1111";
	  Connection conn = null;
	  
	  public Connection getConn() {
		  try {
			  Class.forName(driver); //2
			  conn = DriverManager.getConnection(url,user,pwd);
			  System.out.println("연결성공");
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
		  return conn;		  
	  }
	  
	  public static void main(String[] arg) {
		  new DBConn().getConn();
		  
	  }
	  
}