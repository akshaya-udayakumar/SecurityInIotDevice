package com.ilp.tcs.insurance_management.service;

import java.util.ArrayList;

import com.ilp.tcs.insurance_management.bean.InsuranceTypes;
import com.ilp.tcs.insurance_management.dao.InsTypeDAO;




public class InsTypeService {
	public static int AddInsType(InsuranceTypes type){
		InsTypeDAO instypedao=new InsTypeDAO();
		return instypedao.AddInsType(type);	
	}
	
	public static int EditInsType(InsuranceTypes type){
		InsTypeDAO instypedao=new InsTypeDAO();
		return instypedao.EditInsType(type);	
	}
	
	public static int DeleteInsType(int InsTypeId){
		InsTypeDAO instypedao=new InsTypeDAO();
		return instypedao.DeleteInsType(InsTypeId);	
	}
	
	public static ArrayList<String> getInsType(int InstypeId)
	{
		InsTypeDAO instypedao = new InsTypeDAO();
		return instypedao.getInsType(InstypeId);	
	}
	
	public static ArrayList<String> getAllProducts() {
		// TODO Auto-generated method stub
		InsTypeDAO instypedao=new InsTypeDAO();
		return instypedao.getAllProducts();
	}
	public static ArrayList<String> getActiveProducts(int InsTypeId) {
		// TODO Auto-generated method stub
		InsTypeDAO instypedao=new InsTypeDAO();
		return instypedao.getActiveProducts(InsTypeId);
	}
}
