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

import com.ilp.tcs.insurance_management.bean.InsuranceProducts;
import com.ilp.tcs.insurance_management.service.*;


/**
 * Servlet implementation class InsProductController
 */
@WebServlet("/InsProductController")
public class InsProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * Default constructor. 
	 */
	public InsProductController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String control = request.getParameter("control");

		if(control.equalsIgnoreCase("get"))
		{
			JSONObject objCoverages = new JSONObject();

			JSONArray arrayCoveragesActive = new JSONArray();
			JSONArray arrayCoveragesAll = new JSONArray();
			JSONArray arrayDetails = new JSONArray();

			ArrayList<String> allCoverages = new ArrayList<String>();
			ArrayList<String> activeCoverages = new ArrayList<String>();
			ArrayList<String> productDetails = new ArrayList<String>();

			int productId = Integer.parseInt(request.getParameter("Id"));

			productDetails = InsProductService.getcoverages(productId);
			allCoverages = InsProductService.getAllcoverages();
			activeCoverages = InsProductService.getActivecoverages(productId);

			try {
				for(int i=0;i<allCoverages.size();i++)
				{
					arrayCoveragesAll.put(i,allCoverages.get(i));

				}
				for(int j=0;j<activeCoverages.size();j++)
				{
					arrayCoveragesActive.put(j,activeCoverages.get(j));

				}
				for(int k=0;k<productDetails.size();k++)
				{
					arrayDetails.put(k, productDetails.get(k));

				}
				objCoverages.put("Active", arrayCoveragesActive);
				objCoverages.put("All", arrayCoveragesAll);
				objCoverages.put("Details", arrayDetails);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.getWriter().print(objCoverages);
		}
		if(control.equalsIgnoreCase("show"))
		{
			
			JSONObject objCoverages = new JSONObject();
			JSONArray arrayCoveragesAll = new JSONArray();

			ArrayList<String> allCoverages = new ArrayList<String>();

			allCoverages = InsProductService.getAllcoverages();

			try {
				for(int i=0;i<allCoverages.size();i++)
				{
					arrayCoveragesAll.put(i,allCoverages.get(i));
				}
				objCoverages.put("All", arrayCoveragesAll);
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.getWriter().print(objCoverages);


		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if(action.equals("CreateInsuranceProduct"))
		{
			String[] arrayCoverages;
			String Coverage = "";
			int ProductId=0;

			String InsProductName= request.getParameter("InsProductName");
			String InsProductStatus= request.getParameter("InsProductStatus");
			arrayCoverages = request.getParameterValues("Coverages");

			for(String S: arrayCoverages)
			{
				Coverage = Coverage + S + ",";
			}

			InsuranceProducts insProduct = new InsuranceProducts();

			insProduct.setInsProductStatus(InsProductStatus);
			insProduct.setCoverages(Coverage);
			insProduct.setInsProductName(InsProductName);


			ProductId = InsProductService.AddInsProduct(insProduct);
			if(ProductId > 0)
			{   request.setAttribute("InsProductName", InsProductName);
			    request.setAttribute("InsProductStatus",InsProductStatus);
				request.setAttribute("ProductId", ProductId);
				RequestDispatcher dispatcher =request.getRequestDispatcher("InsProductSuccess.jsp");
				dispatcher.forward(request,response);
			}
			else
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("InsProductFailure.jsp");
				dispatcher.forward(request,response);
			}

		}


		if(action.equalsIgnoreCase("EditInsuranceProduct"))
		{
			int update=0;
			String tempcoverages[];
			String InsProductCoverages = "";
			
			int InsProductId=Integer.parseInt(request.getParameter("InsProductId"));
			String InsProductName= request.getParameter("InsProductName");
			String InsProductStatus= request.getParameter("ProductStatus");
			tempcoverages = request.getParameterValues("Coverages");
			
			for(String str: tempcoverages)
			{
				InsProductCoverages = InsProductCoverages + str + ",";
			}
			
			
			InsuranceProducts product = new InsuranceProducts();
			
			product.setInsProductId(InsProductId);
			product.setInsProductStatus(InsProductStatus);
			product.setCoverages(InsProductCoverages);
			product.setInsProductName(InsProductName);
			
			update = InsProductService.EditInsProduct(product);
			
			if(update == 1)
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("EditSuccess.jsp");
				dispatcher.forward(request,response);
			}
			else
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("EditFailure.jsp");
				dispatcher.forward(request,response);
			}
		}

		if(action.equals("DeleteInsuranceProduct"))
		{
			
			int update = 0;
			
			int InsProductId=Integer.parseInt(request.getParameter("InsProductId"));
			
			update = InsProductService.DeleteInsProduct(InsProductId);
			
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




