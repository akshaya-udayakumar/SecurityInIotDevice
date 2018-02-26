package com.ilp.tcs.insurance_management.controller;

import java.io.IOException;
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

import com.ilp.tcs.insurance_management.bean.User;
import com.ilp.tcs.insurance_management.service.UserService;


/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		JSONObject objUsersDetails = new JSONObject();
		JSONArray arrayUsersDetails = new JSONArray();
		ArrayList<String> userdetails = new ArrayList<String>();
		
		int UserId=Integer.parseInt(request.getParameter("Id"));
	
		
			userdetails = UserService.getuserdetails(UserId);
			
			try {
				 for(int i=0;i<userdetails.size();i++)
				 {
					 arrayUsersDetails.put(i,userdetails.get(i));
				 }
				 objUsersDetails.append("details", arrayUsersDetails);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("application/json");
			response.getWriter().print(objUsersDetails);
			
			
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("CreateUser"))
		{
			int UserId=0;
			int check = 0;
			
			String UserName=request.getParameter("UserName");
			String UserRole=request.getParameter("UserRole");
			String UserStatus=request.getParameter("UserStatus");
			
			User user=new User();
			
			user.setUserName(UserName);
			user.setUserRole(UserRole);
			user.setUserStatus(UserStatus);
			
			UserId = UserService.AddUser(user);
			
			check = UserId;
			if(check > 0 )
				
			{
				request.setAttribute("UserId",check);
				request.setAttribute("UserName", UserName);
				request.setAttribute("UserRole", UserRole);
				request.setAttribute("UserStatus", UserStatus);
				RequestDispatcher dispatcher =request.getRequestDispatcher("UserSuccess.jsp");
				dispatcher.forward(request,response);
			}
			else
			{
				RequestDispatcher dispatcher =request.getRequestDispatcher("UserFailure.jsp");
				dispatcher.forward(request,response);
			}
			
		}
		
		else if(action.equalsIgnoreCase("EditUser"))
		{
			int update =0;
			int UserId = Integer.parseInt(request.getParameter("UserId"));
			String UserName=request.getParameter("UserName");
			String UserRole=request.getParameter("UserRole");
			String UserStatus=request.getParameter("UserStatus");
			
			
			User user=new User();
		
			user.setUserId(UserId);
			user.setUserName(UserName);
			user.setUserRole(UserRole);
			user.setUserStatus(UserStatus);
			
			update = UserService.EditUser(user);
			
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
		
		else if(action.equalsIgnoreCase("DeleteUser"))
		{
			int update = 0;
			int UserId=Integer.parseInt(request.getParameter("UserId"));
			update = UserService.DeleteUser(UserId);
			
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
