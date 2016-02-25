package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.dto.User;
import com.dto.UserRolesRel;
import com.utils.Utils;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRolesRel rel;
	@Transactional
	public void manipulateUserObject(User user) throws Exception{
		user.setCreatedOn(Utils.getCurrentTimeStamp());
	//	user.setPassword(Utils.convertIntoMd5(user.getPassword()));
		user.setPassword(user.getPassword());
		userDao.saveUser(user);
		popoulateUserRoleRel(user);
	}
	@Transactional
	private void popoulateUserRoleRel(User user){
		rel.setRoleId(user.getUserType());
		rel.setUserId(user.getId());
		userDao.saveUserRoleRel(rel);
	}
}
