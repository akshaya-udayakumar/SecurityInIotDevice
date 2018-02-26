package com.ilp.tcs.insurance_management.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.ilp.tcs.insurance_management.bean.Coverage;
import com.ilp.tcs.insurance_management.service.CoverageService;

/**
 * Servlet implementation class CoverageController
 */
@WebServlet("/CoverageController")
public class CoverageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoverageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			JSONObject objCoverageDetails = new JSONObject();
			JSONArray arrayCoverageDetails = new JSONArray();
			ArrayList<String> coveragedetails = new ArrayList<String>();
			
			int CoverageId = Integer.parseInt(request.getParameter("Id"));
			
			coveragedetails = CoverageService.getCoverageDetails(CoverageId);
			
			try {
				for (int i = 0; i<coveragedetails.size();i++)
				{
					arrayCoverageDetails.put(i, coveragedetails.get(i));
				}

				objCoverageDetails.put("details", arrayCoverageDetails);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.setContentType("application/json");
			response.getWriter().print(objCoverageDetails);
			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action=request.getParameter("action");

		if(action.equalsIgnoreCase("CreateCoverage"))
		{
			String CoverageName=request.getParameter("CoverageName");
			String CoverageStatus=request.getParameter("CoverageStatus");
      
			Coverage coverage=new Coverage();

			coverage.setCoverageName(CoverageName);
			coverage.setCoverageStatus(CoverageStatus);
			int CoverageId=0;

			CoverageId = CoverageService.CreateCoverage(coverage);
			
			if(CoverageId > 0)
			{
				request.setAttribute("CoverageId",CoverageId);
				request.setAttribute("CoverageName",CoverageName);
				request.setAttribute("CoverageStatus", CoverageStatus);
				RequestDispatcher dispatcher = request.getRequestDispatcher("CoverageSuccess.jsp");
				dispatcher.forward(request,response);
			}
			else
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("CoverageFailure.jsp");
				dispatcher.forward(request,response);
			}
		}

		if(action.equalsIgnoreCase("EditCoverage"))
		{
			int CoverageId = Integer.parseInt(request.getParameter("CoverageId"));
			String CoverageName = request.getParameter("CoverageName");
			String CoverageStatus = request.getParameter("CoverageStatus");
			Coverage coverage=new Coverage();

			coverage.setCoverageId(CoverageId);
			coverage.setCoverageName(CoverageName);
			coverage.setCoverageStatus(CoverageStatus);

			int update=0;

			update = CoverageService.EditCoverage(coverage);

			if(update == 1)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("EditSuccess.jsp");
				dispatcher.forward(request,response);
			}
			else
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("EditFailure.jsp");
				dispatcher.forward(request,response);
			}
		}

		if(action.equalsIgnoreCase("DeleteCoverage"))
		{
			int CoverageId=Integer.parseInt(request.getParameter("CoverageId"));
			int update=0;

			update=CoverageService.DeleteCoverage(CoverageId);

			if(update == 1)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("DeleteSuccess.jsp");
				dispatcher.forward(request,response);
			}
			else
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("DeleteFailure.jsp");
				dispatcher.forward(request,response);
			}

		}

	}

}
