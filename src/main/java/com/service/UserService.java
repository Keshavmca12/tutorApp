package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.dto.User;
import com.utils.Utils;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public void manipulateUserObject(User user) throws Exception{
		user.setCreatedOn(Utils.getCurrentTimeStamp());
		user.setPassword(Utils.convertIntoMd5(user.getPassword()));
		userDao.saveUser(user);
	}
}
