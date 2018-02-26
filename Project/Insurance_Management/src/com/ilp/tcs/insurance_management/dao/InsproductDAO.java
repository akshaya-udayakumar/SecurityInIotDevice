package com.ilp.tcs.insurance_management.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp.tcs.insurance_management.bean.InsuranceProducts;
import com.ilp.tcs.insurance_management.util.DBConnection;



public class InsproductDAO {

	private Connection connection=null;
	private PreparedStatement ps= null,ps1=null,ps2=null, ps3=null;
	private ResultSet rs=null;

	public int AddInsProduct(InsuranceProducts product)
	{

		int Productid=0;

		DBConnection db=new DBConnection();
		connection=db.getConnection();

		String productconcat = product.getCoverages();
		String producttemp[];
		producttemp = productconcat.split(",");

		try
		{
			ps1=connection.prepareStatement("insert into Product_details values(product_sequence.nextval,?,?)");
			ps1.setString(1,product.getInsProductName());
			ps1.setString(2,product.getInsProductStatus());
			ps1.executeQuery();

			for(int i=0;i<producttemp.length;i++)
			{
				ps2= connection.prepareStatement("insert into Product_Coverage_details values(product_sequence.CurrVal,?)");
				ps2.setString(1, producttemp[i]);
				ps2.executeQuery();
			}

			ps3 = connection.prepareStatement("select product_sequence.CurrVal as id FROM DUAL");
			rs= ps3.executeQuery();
			while(rs.next())
			{
				Productid = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error in adding values into Data Base");
			return Productid;
		}

		finally
		{
			if(connection!=null){
				db.closeConnection();
				try {
					ps1.close();
					ps2.close();
					ps3.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return Productid;
	}
	
	public int EditInsProduct(InsuranceProducts product) {
		// TODO Auto-generated method stub

		int update=0;

		DBConnection db = new DBConnection();
		connection = db.getConnection();
		try
		{
			ps1=connection.prepareStatement("update Product_details set Product_Name = ?, Product_Status = ? where Product_id = ?");
			ps1.setString(1,product.getInsProductName());
			ps1.setString(2,product.getInsProductStatus());
			ps1.setInt(3, product.getInsProductId());
			ps1.executeUpdate();

			String productconcat = product.getCoverages();
			
			String producttemp[];
			producttemp = productconcat.split(",");
			for(int i=0;i<producttemp.length;i++)
			{
				System.out.println(product.getInsProductId());
				ps2= connection.prepareStatement("update Product_Coverage_details set Coverage = ? where Product_Id = ? ");

				ps2.setString(1, producttemp[i]);
				ps2.setInt(2,product.getInsProductId());
				ps2.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in adding values into Data Base");
			return update;
		}
		finally
		{
			if(connection!=null){
				db.closeConnection();
				try {
					ps1.close();
					ps2.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}

			}
		}
		return update;
	}
	
	public int DeleteInsProduct(int ProductId)  {
		// TODO Auto-generated method stub

		int update = 0;
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		try
		{
			ps1 = connection.prepareStatement("DELETE FROM Product_Coverage_details WHERE Product_Id=?" );
			ps1.setInt(1,ProductId);
			ps1.executeUpdate();
			ps2 = connection.prepareStatement("DELETE FROM Product_details where Product_Id=?");
			ps2.setInt(1,ProductId);
			update = ps2.executeUpdate();
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
					ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return update;
	}

	public ArrayList<String> getproduct(int ProductId)  {
		// TODO Auto-generated method stub
		ArrayList<String> productDetails = new ArrayList<String>();

		DBConnection db= new DBConnection();
		connection = db.getConnection();

		try
		{
			ps=connection.prepareStatement("select * from product_details where product_id = ? ");
			ps.setInt(1, ProductId);
			rs=ps.executeQuery();
			while (rs.next()) 
			{
				productDetails.add(rs.getString(2));
				productDetails.add(rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null){
				db.closeConnection();
				try {
					ps.close();
					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return productDetails;
	}
	
	public ArrayList<String> getAllCoverages() {
		// TODO Auto-generated method stub
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		ArrayList<String> activeCov = new ArrayList<>();
		try
		{
			ps= connection.prepareStatement("select * from Coverage_details where Coverage_Status='Active'");
			rs = ps.executeQuery();
			while(rs.next())
			{
				activeCov.add(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return activeCov;
	}

	public ArrayList<String> getActiveCoverages(int productId) {
		// TODO Auto-generated method stub
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		ArrayList<String> allCov = new ArrayList<>();
		try
		{
			ps = connection.prepareStatement("select * from Product_Coverage_details where product_id = ?");
			ps.setInt(1,productId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				allCov.add(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return allCov;
	}
	
}








