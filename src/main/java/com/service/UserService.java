package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.dto.User;
import com.utils.Utils;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public HashMap<String, Object> manipulateUserObject(User user) throws Exception{
		HashMap<String, Object> responseMap=new HashMap<String, Object>();
		List<String> responseList=new ArrayList<String>();
		boolean isEmailUnique=isEmailUnique(user.getEmail());
		boolean isMobileNoUnique=isMobileNoUnique(user.getMobileNo());
		if(!isEmailUnique|| !isMobileNoUnique){
			if(!isEmailUnique){
				responseList.add("email id already registered");
			}
			if(!isMobileNoUnique){
				responseList.add("mobile no. already registered");
			}
			responseMap.put("status", "invalid");
			responseMap.put("messageList",responseList);
			return responseMap;
		}
		user.setCreatedOn(Utils.getCurrentTimeStamp());
		user.setPassword(Utils.convertIntoMd5(user.getPassword()));
		userDao.saveUser(user);
		responseList.add("user registered successfully");
		responseMap.put("status", "valid");
		responseMap.put("messageList",responseList);
		return responseMap;
	}
	public Map<String, String> verifyUser(String password,HttpSession session,String username,HttpServletRequest request) throws Exception{
		Map<String,String> userAvailaibility=new HashMap<String, String>();
		List<User> userList=userDao.isUserVerified(Utils.convertIntoMd5(password),username);
		if(userList==null || userList.size()==0){
			userAvailaibility.put("status", "invalid user");
		}else{
			User user=userList.get(0);
			session = request.getSession(true);//equivalent to request.getSession();
			session.setAttribute("user",user);
			userAvailaibility.put("status", "valid user");
		}
		return userAvailaibility;
	}

	public boolean isEmailUnique(String email){
		boolean isAvailable=false;
		System.out.println("email check ::"+email);
		List<User> userList=userDao.checkEmailForUser(email);
		if(userList==null || userList.size()==0){
			isAvailable=true;
		}
		return isAvailable;
	}

	public boolean isMobileNoUnique(String mobileNo){
		boolean isAvailable=false;
		System.out.println("mobile no check :: "+mobileNo);
		List<User> userList=userDao.checkMobileNoOfUser(mobileNo);
		if(userList==null || userList.size()==0){
			isAvailable=true;
		}
		return isAvailable;
	}
}
