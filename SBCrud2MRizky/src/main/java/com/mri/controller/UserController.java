package com.mri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mri.models.UserModel;
import com.mri.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService us;
	
	/*Halaman Login*/
	@RequestMapping("login")
	public String Login() {
		return "auth/login";
	}
	
	@RequestMapping(value = "logon", method = RequestMethod.POST)
	public String logon(UserModel um) {
		List<UserModel>logon=us.logon(um.getUsers(), um.getPassword());
		String page = "";
		if(logon.size()>0) {
			page = "redirect:/listbarang";
		}else {
			page = "redirect:/login";
		}
		return page;
	}
}
