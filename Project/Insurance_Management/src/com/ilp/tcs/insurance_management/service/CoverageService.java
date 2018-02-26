package com.ilp.tcs.insurance_management.service;


import java.util.ArrayList;

import com.ilp.tcs.insurance_management.bean.Coverage;
import com.ilp.tcs.insurance_management.dao.CoverageDAO;


public class CoverageService {
	public static int CreateCoverage(Coverage coverage)
	{
		CoverageDAO coveragedao = new CoverageDAO();
		return coveragedao.CreateCoverage(coverage);	
	}
	
	public static int EditCoverage(Coverage coverage){
		CoverageDAO coveragedao = new CoverageDAO();
		return coveragedao.EditCoverage(coverage);	
	}
	
	public static int DeleteCoverage(int CoverageId){
		CoverageDAO coveragedao = new CoverageDAO();
		return coveragedao.DeleteCoverage(CoverageId);	
	}
	
	public static ArrayList<String> getCoverageDetails(int CoverageId){
		CoverageDAO coveragedao = new CoverageDAO();
		return coveragedao.getCoverageDetails(CoverageId);	
	}
}
