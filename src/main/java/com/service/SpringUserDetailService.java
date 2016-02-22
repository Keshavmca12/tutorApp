package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.dto.Roles;
import com.dto.User;
@Service("springUserDetailService")
public class SpringUserDetailService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userDao.findUserByUserName(username);
		System.out.println("User : "+user);
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		List<GrantedAuthority> authorities= getGrantedAuthorities(user);
		System.out.println("authorities  "+authorities);
		return new org.springframework.security.core.userdetails.User(user.getMobileNo(), user.getPassword(), 
				true, true, true, true, authorities);
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for(Roles role : user.getRole()){
			System.out.println("role : "+role);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
		}
		System.out.print("authorities :"+authorities);
		return authorities;
	}

}
