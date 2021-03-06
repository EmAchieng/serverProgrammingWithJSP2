package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	static {
	try {
	Class.forName("org.gjt.mm.mysql.Driver");
	
	}
	catch(ClassNotFoundException e)	 {
	e.printStackTrace();
	
	}
	}
	
	public static Connection getConnection() { Connection con = null;
	try {
	
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/loginservlet?useUnicode=true&characterEncoding=EUC_KR",
			"root","mariadb");
	
	//checking connection
	System.out.println(con);
	
	con.setAutoCommit(false);
	
	}
	catch (SQLException e) {
	e.printStackTrace()	;
	}
	return con;	
	}
public static void close(Connection con) {
	try {
		con.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
	public static void close(Statement stmt) {
	try {
		stmt.close();
	}
	catch(Exception e) {
		e.printStackTrace();
	
	}
	}
	public static void close(ResultSet rs) {
	try {
		rs.close();
	}
	catch(Exception e) {
	e.printStackTrace();
	}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
			System.out.println("commit success");
		}
		catch(Exception e) {
			System.out.println("commit fail");
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("rollback success");
		}
		catch(Exception e) {
			System.out.println("rollback fail");
		}
	}

}
