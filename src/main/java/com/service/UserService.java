package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.dto.User;
import com.utils.Utils;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public List<String> manipulateUserObject(User user) throws Exception{
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
			return responseList;
		}
		user.setCreatedOn(Utils.getCurrentTimeStamp());
		user.setPassword(Utils.convertIntoMd5(user.getPassword()));
		userDao.saveUser(user);
		responseList.add("user registered successfully");
		return responseList;
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
