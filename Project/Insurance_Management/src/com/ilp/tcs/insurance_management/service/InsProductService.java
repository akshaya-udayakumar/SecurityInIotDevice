package com.ilp.tcs.insurance_management.service;

import java.util.ArrayList;

import com.ilp.tcs.insurance_management.bean.InsuranceProducts;
import com.ilp.tcs.insurance_management.dao.InsproductDAO;


public class InsProductService 
{
	public static int AddInsProduct(InsuranceProducts product)
	{
		InsproductDAO insproductdao = new InsproductDAO();
		return insproductdao.AddInsProduct(product);	
	}
	
	public static int EditInsProduct(InsuranceProducts product)
	{
		InsproductDAO insproductdao = new InsproductDAO();
		return insproductdao.EditInsProduct(product);	
	}
	public static int DeleteInsProduct(int InsProductId)
	{
		InsproductDAO insproductdao = new InsproductDAO();
		return insproductdao.DeleteInsProduct(InsProductId);	
}
	public static ArrayList<String> getcoverages(int InsProductId)
	{
		InsproductDAO insproductdao = new InsproductDAO();
		return insproductdao.getproduct(InsProductId);	
	}
	
	public static ArrayList<String> getAllcoverages() {
		// TODO Auto-generated method stub
		InsproductDAO insproductdao = new InsproductDAO();
		return insproductdao.getAllCoverages();
	}
	public static ArrayList<String> getActivecoverages(int productId) {
		// TODO Auto-generated method stub
		InsproductDAO insproductdao = new InsproductDAO();
		return insproductdao.getActiveCoverages(productId);
	}
}

