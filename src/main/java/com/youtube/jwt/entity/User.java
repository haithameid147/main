package com.youtube.jwt.entity;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="`users`")
public class User implements java.io.Serializable {

//  private Integer id ;
	@Id
	private String userName;
	private String userFirstName;
	private String userLastName;
	private String mobile ;
	private String userPassword;
	@CreationTimestamp  //note that if you want to update time use @UpdateTimeStamp
	private Date userDateCreation;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private Set<Role> role;

	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Foundation> foundation = new HashSet<Foundation>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
   
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getUserDateCreation() {
		return userDateCreation;
	}

	public void setUserDateCreation(Date userDateCreation) {
		this.userDateCreation = userDateCreation;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Set<Foundation> getFoundation() {
		return foundation;
	}

	public void setFoundation(Set<Foundation> foundation) {
		this.foundation = foundation;
	}

//	public Set<Foundation> getFoundation() {
//		return foundation;
//	}
//
//	public void setFoundation(Set<Foundation> foundation) {
//		this.foundation = foundation;
//	}
	
	

//    public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
}
