package com.ilp.tcs.insurance_management.service;

import java.util.ArrayList;

import com.ilp.tcs.insurance_management.bean.User;
import com.ilp.tcs.insurance_management.dao.UserDAO;


public class UserService 
{

	public static int AddUser(User user)
	{
		UserDAO userdao = new UserDAO();
		return userdao.AddUser(user);
	}

	public static int EditUser(User user)
	{
		UserDAO userdao = new UserDAO();
		return userdao.EditUser(user);	
	}

	public static int DeleteUser(int UserId)
	{
		UserDAO userdao = new UserDAO();
		return userdao.DeleteUser(UserId);	
	}

	public static ArrayList<String> getuserdetails(int userId)
	{
		UserDAO userdao = new UserDAO();
		return userdao.getUserDetails(userId);	
	}
}