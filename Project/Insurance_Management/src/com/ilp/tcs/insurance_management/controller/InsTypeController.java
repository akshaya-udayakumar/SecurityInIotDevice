package com.ilp.tcs.insurance_management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ilp.tcs.insurance_management.bean.InsuranceTypes;
import com.ilp.tcs.insurance_management.service.InsProductService;
import com.ilp.tcs.insurance_management.service.InsTypeService;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Servlet implementation class Delete
 */
@WebServlet("/InsTypeController")
public class InsTypeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public InsTypeController() {
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
			JSONObject objProducts = new JSONObject();
			JSONArray arrayProductsActive = new JSONArray();
			JSONArray arrayProductsAll = new JSONArray();
			JSONArray arrayDetails = new JSONArray();

			ArrayList<String> allProducts = new ArrayList<String>();
			ArrayList<String> activeProducts = new ArrayList<String>();
			ArrayList<String> InsTypeDetails = new ArrayList<String>();

			int InsTypeId = Integer.parseInt(request.getParameter("Id"));

			InsTypeDetails = InsTypeService.getInsType(InsTypeId);
			allProducts = InsTypeService.getAllProducts();
			activeProducts = InsTypeService.getActiveProducts(InsTypeId);

			try {
				for(int i=0;i<allProducts.size();i++)
				{
					arrayProductsAll.put(i,allProducts.get(i));

				}
				for(int j=0;j<activeProducts.size();j++)
				{
					arrayProductsActive.put(j,activeProducts.get(j));

				}
				for(int k=0;k<InsTypeDetails.size();k++)
				{
					arrayDetails.put(k, InsTypeDetails.get(k));
				}
				objProducts.put("Active", arrayProductsActive);
				objProducts.put("All", arrayProductsAll);
				objProducts.put("Details", arrayDetails);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.getWriter().print(objProducts);
		}
		if(control.equalsIgnoreCase("show"))
		{
			JSONObject objProducts = new JSONObject();
			JSONArray arrayProductsAll = new JSONArray();

			ArrayList<String> allProducts = new ArrayList<String>();

			allProducts = InsTypeService.getAllProducts();

			try {
				for(int i=0;i<allProducts.size();i++)
				{
					arrayProductsAll.put(i,allProducts.get(i));

				}
				objProducts.put("All", arrayProductsAll);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.getWriter().print(objProducts);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if(action.equals("CreateInsuranceType"))
		{
			int InsTypeId=0;
			String ProductsApplicable="";

			String InsTypeName = request.getParameter("InsTypeName");
			String ProductsApplicableTemp[] = request.getParameterValues("ProductsApplicable");
			String InsTypeStatus= request.getParameter("InsTypestatus");

			for(String str: ProductsApplicableTemp)
			{
				ProductsApplicable=ProductsApplicable+str+",";
			}

			InsuranceTypes insType=new InsuranceTypes();

			insType.setInsTypeName(InsTypeName);
			insType.setProductsApplicable(ProductsApplicable);
			insType.setInsTypestatus(InsTypeStatus);

			InsTypeId=InsTypeService.AddInsType(insType);
			if(InsTypeId > 0)
			{
				request.setAttribute("InsTypeId",InsTypeId);
				request.setAttribute("InsTypeName", InsTypeName);
				request.setAttribute("InsTypeStatus", InsTypeStatus);
				RequestDispatcher dispatcher =request.getRequestDispatcher("InsTypeSuccess.jsp");
				dispatcher.forward(request,response);
			}
			else
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("InsTypeFailure.jsp");
				dispatcher.forward(request,response);
			}
		}

		if(action.equalsIgnoreCase("EditInsuranceType"))
		{
			int update=0;
			String ProductsApplicable="";
			
			int InsTypeId = Integer.parseInt(request.getParameter("InsTypeId"));
			String InsTypeName = request.getParameter("InsTypeName");
			String ProductsApplicableTemp[] = request.getParameterValues("ProductsApplicable");
			String InsTypeStatus= request.getParameter("Typestatus");
			
			
			for(String str: ProductsApplicableTemp)
			{
				ProductsApplicable=ProductsApplicable+str+",";
			}
			
			InsuranceTypes insType = new InsuranceTypes();
			
			insType.setInsTypeId(InsTypeId);
			insType.setInsTypeName(InsTypeName);
			insType.setProductsApplicable(ProductsApplicable);
			insType.setInsTypestatus(InsTypeStatus);
			
			update=InsTypeService.EditInsType(insType);
			
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




		else if(action.equals("DeleteInsuranceType"))
		{
			int update = 0;	
			int InsTypeId = Integer.parseInt(request.getParameter("InsTypeId"));
			
			update = InsTypeService.DeleteInsType(InsTypeId);

			if(update == 1)
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("DeleteSuccess.jsp");
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
