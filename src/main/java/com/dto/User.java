package com.dto;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
@Access(AccessType.PROPERTY)
@NamedQueries({@NamedQuery(name = "User.findByEmail", 
query = "SELECT u FROM User u WHERE u.email = :email"),
@NamedQuery(name = "User.findByMobileNo", 
query = "SELECT u FROM User u WHERE u.mobileNo = :mobileNo"),
@NamedQuery(name = "User.findByUsernamePassword", 
query = "SELECT u FROM User u WHERE u.password = :password and u.mobileNo =:username")})
public class User {

	private int id;
	private String name;
	private String email;
	private  String mobileNo;
	private String password;
	private short sex;
	private short role;
	private short isCompleted=-1;
	private short isBlacklisted=-1;
	private long createdOn;
	@Column(name = "CREATED_ON", nullable = false)
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	@Column(name="IS_BLACKLISTED", nullable = false)
	public short getIsBlacklisted() {
		return isBlacklisted;
	}
	public void setIsBlacklisted(short isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "EMAIL", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "MOBILE_NO", unique = true, nullable = false)
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Column(name = "PASSWORD",nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "SEX_ID",nullable = false)
	public short getSex() {
		return sex;
	}
	public void setSex(short sex) {
		this.sex = sex;
	}
	@Column(name = "ROLE_ID",nullable = false)
	public short getRole() {
		return role;
	}
	public void setRole(short role) {
		this.role = role;
	}
	@Column(name = "IS_COMPLETED",nullable = false)
	public short getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(short isCompleted) {
		this.isCompleted = isCompleted;
	}
     @Override
    public String toString() {
    	return "name  ::"+name+"  email ::"+email +"  mobile no ::"+mobileNo+" role :: "+role;
    }
}
