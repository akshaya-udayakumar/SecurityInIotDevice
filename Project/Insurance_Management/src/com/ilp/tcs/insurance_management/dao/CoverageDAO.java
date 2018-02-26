package com.ilp.tcs.insurance_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.ilp.tcs.insurance_management.bean.Coverage;
import com.ilp.tcs.insurance_management.util.DBConnection;


public class CoverageDAO {

	private Connection connection=null;
	private PreparedStatement ps1=null,ps2=null;
	private ResultSet rs=null;

	public int CreateCoverage(Coverage coverage) 
	{

		int CoverageId=0;
		DBConnection db = new DBConnection();
		connection = db.getConnection();

		try
		{
			ps1=connection.prepareStatement("insert into Coverage_details values(coverage_sequence.nextval,?,?)");
			ps1.setString(1,coverage.getCoverageName());
			ps1.setString(2,coverage.getCoverageStatus());
			ps1.executeQuery();

			ps2=connection.prepareStatement("select coverage_sequence.currval FROM DUAL");
			rs=ps2.executeQuery();
			while(rs.next())
			{
				CoverageId = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error in adding values into Data Base");
			return CoverageId;
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return CoverageId;

	}
	
	public int EditCoverage(Coverage coverage)
	{
		
		int update=0;

		DBConnection db=new DBConnection();
		connection=db.getConnection();


		try
		{
			ps1=connection.prepareStatement("update Coverage_details set Coverage_Name= ?,Coverage_Status= ? where Coverage_Id = ?");
			ps1.setString(1,coverage.getCoverageName());
			ps1.setString(2,coverage.getCoverageStatus());
			ps1.setInt(3, coverage.getCoverageId());
			
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		return update;
	}
	
	public int DeleteCoverage(int CoverageId) 
	{
		
		int update= 0;
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		try
		{
			ps1 = connection.prepareStatement("DELETE FROM Coverage_details WHERE Coverage_Id =?" );
			ps1.setInt(1,CoverageId);
			update=ps1.executeUpdate();

		}
		catch(SQLException e)
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
	
	public ArrayList<String> getCoverageDetails(int CoverageId)
	{
		ArrayList<String> viewCoverages = new ArrayList<String>();
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		try
		{
			ps1 = connection.prepareStatement("SELECT * FROM Coverage_details WHERE Coverage_Id = ?" );
			ps1.setInt(1,CoverageId);
			rs=ps1.executeQuery();
			while(rs.next())
			{	
				viewCoverages.add(rs.getString(2));
				viewCoverages.add(rs.getString(3));
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
		return viewCoverages;
	} 

	

}
