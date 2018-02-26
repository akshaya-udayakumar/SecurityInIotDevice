package com.ilp.tcs.insurance_management.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp.tcs.insurance_management.bean.User;
import com.ilp.tcs.insurance_management.util.DBConnection;


public class UserDAO 
{
	private Connection connection=null;
	private PreparedStatement ps1=null,ps2=null;
	private ResultSet rs=null;

	public int AddUser(User user) 
	{

		int UserId=0;
		DBConnection db=new DBConnection();
		connection = db.getConnection();

		try
		{
			ps1=connection.prepareStatement("insert into User_details values(user_sequence.nextval,?,?,?)");
			ps1.setString(1,user.getUserName());
			ps1.setString(2,user.getUserRole());
			ps1.setString(3,user.getUserStatus());
			ps1.executeQuery();

			ps2=connection.prepareStatement("select user_sequence.CurrVal FROM DUAL");
			rs=ps2.executeQuery();
			while(rs.next())
			{
				UserId = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error in adding values into Data Base");
			return UserId;
		}
		finally
		{
			if(connection!=null)
			{
				db.closeConnection();
				try {
					ps1.close();
					ps2.close();
					rs.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		}
		return UserId;

	}
	
	public int EditUser(User user) 
	{

		int update=0;

		DBConnection db=new DBConnection();
		connection=db.getConnection();

		try
		{
			ps1=connection.prepareStatement("update User_details set User_Name= ?,User_Role=?,User_Status=? where User_Id = ? ");
			ps1.setString(1,user.getUserName());
			ps1.setString(2,user.getUserRole());
			ps1.setString(3,user.getUserStatus());
			ps1.setInt(4, user.getUserId());

			update = ps1.executeUpdate();

		}
		catch(SQLException e)
		{
			System.out.println("Error in adding values into Data Base");
			return update;
		}
		finally
		{
			if(connection!=null)
			{
				db.closeConnection();
				try {
					ps1.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return update;
	}

	public int DeleteUser(int UserId) 
	{

		int update= 0;
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		try
		{
			ps1 = connection.prepareStatement("DELETE FROM User_details WHERE User_Id = ?" );
			ps1.setInt(1,UserId);
			update = ps1.executeUpdate();

		}
		catch(Exception e)
		{
			System.out.println("Error in deleting values from Data Base");
			return update;
		}
		finally
		{
			if(connection!=null)
			{
				db.closeConnection();
				try {
					ps1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return update;
	}
	
	
	public ArrayList<String> getUserDetails(int UserId) 
	{
		ArrayList<String> ViewUser = new ArrayList<String>();
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		try
		{ 
			
			ps1 = connection.prepareStatement("SELECT * FROM User_details WHERE User_Id = ?" );
			ps1.setInt(1,UserId);
			rs=ps1.executeQuery();
			while(rs.next())

			{	
				ViewUser.add(rs.getString(2));
				ViewUser.add(rs.getString(3));
				ViewUser.add(rs.getString(4));
				
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
			{
				db.closeConnection();
				try {
					ps1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return ViewUser;
	} 


	


}






