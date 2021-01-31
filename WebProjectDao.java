package edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.dto.WebProjectDto;
import edu.util.DBUtil;

public class WebProjectDao {
	private static WebProjectDao wpdao = new WebProjectDao();
	
	public static WebProjectDao getWebProjectDao() {
		return wpdao;
	}
	
	public boolean insertWebProject(WebProjectDto wp) {
		Connection con = DBUtil.connect();
		boolean status = false;
		String query = "INSERT INTO WebProject VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);	

			
			ps.setString   (1, wp.getName());
			ps.setString   (2, wp.getEmail());
			ps.setString   (3, wp.getPhone());
			ps.setString   (4, wp.getAddress());
			ps.setString   (5, wp.getCity());
			ps.setInt      (6, wp.getPincode());
			ps.setString   (7, wp.getState());
			ps.setString   (8, wp.getCountry());

			if(ps.executeUpdate()>0) {
				status =true;
			}
			
		} catch (SQLException e) {
			System.out.println("WebProjectDao > insertWebProject : "+e);		
		}
		
		return status;
	}
}
