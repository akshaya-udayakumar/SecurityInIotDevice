package com.ilp.tcs.insurance_management.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp.tcs.insurance_management.bean.InsuranceTypes;
import com.ilp.tcs.insurance_management.util.DBConnection;


public class InsTypeDAO {
	private Connection connection=null;
	private PreparedStatement ps = null,ps1=null,ps2=null, ps3=null;
	private ResultSet rs=null;
	
	public int AddInsType(InsuranceTypes type) 
	{
			
			int Productid=0;
			
			DBConnection db=new DBConnection();
			connection=db.getConnection();
			
			String productapplicableconcat =type.getProductsApplicable();
			String productapplicabletemp[];
			productapplicabletemp = productapplicableconcat.split(",");
		
		try
		{
		ps1=connection.prepareStatement("insert into Insurance_Types_details values(insurance_sequence.nextval,?,?)");
		ps1.setString(1,type.getInsTypeName());
		ps1.setString(2,type.getInsTypestatus());
		ps1.executeUpdate();
		
		for(int i=0;i<productapplicabletemp.length;i++)
		{
			
			ps2= connection.prepareStatement("insert into Insutypes_Product_details values(insurance_sequence.CurrVal,?)");
			ps2.setString(1, productapplicabletemp[i]);
			ps2.executeUpdate();
		}
		
		ps3=connection.prepareStatement("select insurance_sequence.CurrVal as id FROM DUAL");
		rs= ps3.executeQuery();
		while(rs.next())
		{
			Productid=rs.getInt(1);
		}
		}
		
		 catch(SQLException e)
		{
			e.printStackTrace();
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
	
	public int EditInsType(InsuranceTypes type) {
		// TODO Auto-generated method stub
		
		
		int update=0;
	
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		try
		{
			ps1=connection.prepareStatement("update Insurance_Types_details set Insu_Name= ?, Insu_Status= ? where Product_id=?");
			ps1.setString(1,type.getInsTypeName());
			ps1.setString(2,type.getInsTypestatus());
			ps1.setInt(3,type.getInsTypeId() );
			update=ps1.executeUpdate();
			
			String productapplicableconcat =type.getProductsApplicable();
			String productapplicabletemp[];
			productapplicabletemp = productapplicableconcat.split(",");
			for(int i=0;i<productapplicabletemp.length;i++)
			{
				//System.out.println(producttemp.length);
				ps2= connection.prepareStatement("update Insutypes_Product_details set Product_Applicable= ? where Product_Id=?");
				ps2.setString(1, productapplicabletemp[i]);
				ps2.setInt(2,type.getInsTypeId() );
				update=ps2.executeUpdate();
			}
			
		}
		catch(SQLException e)
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
					ps3.close();
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return update;
	}
	
	public int DeleteInsType(int ProductId) {
		// TODO Auto-generated method stub
		
		int update = 0;
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		try
		{
			ps1 = connection.prepareStatement("DELETE FROM Insutypes_Product_details WHERE Insu_Id=?" );
			ps1.setInt(1,ProductId);
			ps1.executeUpdate();
			ps2 = connection.prepareStatement("DELETE FROM Insurance_Types_details where Insu_Id=?");
			ps2.setInt(1,ProductId);
			update= ps2.executeUpdate();
			
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
	public ArrayList<String> getInsType(int InsuTypeId) {
		// TODO Auto-generated method stub
		ArrayList<String> InsTypeDetails = new ArrayList<String>();
	
		DBConnection db= new DBConnection();
		connection = db.getConnection();
		
		try
		{
		ps=connection.prepareStatement("select * from Insurance_Types_details where Insu_Id = ? ");
		ps.setInt(1, InsuTypeId);
		rs=ps.executeQuery();
		
        while (rs.next()) 
        {
        	InsTypeDetails.add(rs.getString(2));
        	InsTypeDetails.add(rs.getString(3));	
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
		return InsTypeDetails;
	}
	


	public ArrayList<String> getAllProducts() {
		// TODO Auto-generated method stub
	
	
	
		DBConnection db = new DBConnection();
		connection = db.getConnection();
			// TODO Auto-generated method stub
			ArrayList<String> allPro = new ArrayList<>();
			try
			{
				ps = connection.prepareStatement("select * from Product_details where Product_Status='Active'");
				rs = ps.executeQuery();
				
				while(rs.next())
				{
					allPro.add(rs.getString(2));
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return allPro;
		
	}


	public ArrayList<String> getActiveProducts(int InsTypeId) {
		// TODO Auto-generated method stub
		DBConnection db = new DBConnection();
		connection = db.getConnection();
		ArrayList<String> activePro = new ArrayList<>();
		try
		{
			ps= connection.prepareStatement("select * from Insutypes_Product_details where insu_id = ?");
			ps.setInt(1,InsTypeId);
			rs = ps.executeQuery();
			while(rs.next())
			{
				activePro.add(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return activePro;
	}

}
