package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entities.*;
import com.mysql.cj.xdevapi.PreparableStatement;
public class UserDao {
	private Connection conn;
	private User us;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}	
	
	
	public boolean userRegister(User us)
	{
		boolean f=false;
		try {
			String qu = "insert into user(name,email,password) values (?,?,?)";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			ps.executeUpdate();
			f=true;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	public User getLogin(String email,String password)
	{
		User us=null;
		try {

			String qu= "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet set = ps.executeQuery();
			
			if(set.next())
			{
				us =new User(set.getInt(1),set.getString(2),set.getString(3),set.getString(4));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}
	
	
	
}
