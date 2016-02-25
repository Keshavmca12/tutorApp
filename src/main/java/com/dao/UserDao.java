package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dto.Roles;
import com.dto.User;
import com.dto.UserRolesRel;

@Repository
public class UserDao {
	private SessionFactory sessionFactory;
	@Autowired
	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public void saveUser(User user){
		System.out.println("saving user data"+user.getMobileNo());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().save(user);
	}
	@Transactional
	public User findUserByUserName(String userName){
		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from User where mobileNo=?")
			.setParameter(0, userName).list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
	@Transactional
	public void  saveUserRoleRel(UserRolesRel rel){
		System.out.println("saving user :"+rel.getRoleId());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().save(rel);
	}
	
	
	
}
