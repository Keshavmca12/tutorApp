package com.dao;

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
}
