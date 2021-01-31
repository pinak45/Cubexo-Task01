package edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	static Properties p;
	static String url=null;
	
	public DBUtil() {
		
	}
	static{
		try {
			p = new Properties();
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties"));
			String driver = p.getProperty("driver");
            url  = p.getProperty("url");
            Class.forName(driver);
		} catch (Exception e) {
		}  
	}

	public static Connection connect() {
		try {
			Connection con = DriverManager.getConnection(url, p);
			return con;
		} catch (SQLException e) {
			 System.out.println("DBUtil > connect : "+e);
		}
           return null;
	}
	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if(con!=null) {
				con.close();
			}
			if(st!=null) {
				st.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}catch(Exception e) {
			System.out.println("DBUtil > close : "+e);
		}
	}
}
