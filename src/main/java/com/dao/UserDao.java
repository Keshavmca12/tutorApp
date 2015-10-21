package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dto.User;

@Repository
public class UserDao {
	private SessionFactory sessionFactory;
	@Autowired
	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public void saveUser(User user){
		System.out.println("saving user data");
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().save(user);
	}
	@Transactional
	public List<User> checkEmailForUser(String email){
		System.out.println("checking email existence");
		sessionFactory.getCurrentSession().flush();
		Query query = sessionFactory.getCurrentSession().getNamedQuery("User.findByEmail");
		query.setString("email", email);
		List<User> users = query.list();
		System.out.println("email users list :: "+users);
		return users;
	}
	@Transactional
	public List<User> isUserVerified(String password,String username){
		System.out.println("checking isUserVerified");
		sessionFactory.getCurrentSession().flush();
		Query query = sessionFactory.getCurrentSession().getNamedQuery("User.findByUsernamePassword");
		query.setString("username",username);
		query.setString("password", password);
		List<User> users = query.list();
		System.out.println("users verified :: "+users);
		return users;
	}
	
	@Transactional
	public List<User> checkMobileNoOfUser(String mobileNo){
		System.out.println("checking phone no. existence");
		sessionFactory.getCurrentSession().flush();
		Query query = sessionFactory.getCurrentSession().getNamedQuery("User.findByMobileNo");
		query.setString("mobileNo", mobileNo);
		List<User> users = query.list();
		System.out.println("mobile no users list :: "+users);
		return users;
	}
}
