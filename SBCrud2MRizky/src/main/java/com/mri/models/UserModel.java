package com.mri.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mUsers")
public class UserModel {
	
	@Id
	@Column(name="idusers")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String users;
	private String password;
	private Boolean islogin;
	
	/*-=Getter Setter=-*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIslogin() {
		return islogin;
	}
	public void setIslogin(Boolean islogin) {
		this.islogin = islogin;
	}
}
