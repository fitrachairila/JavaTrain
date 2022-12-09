package com.app.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.usermodel;
import com.app.service.userserv;

@Controller
public class usercontroller {

	@Autowired
	private userserv ps;

	@PostMapping(value = "signin")
	public ResponseEntity<Object> signin(@RequestBody Map<String, Object> dt) {
		System.out.println(dt.get("users").toString());
		System.out.println(dt.get("password").toString());
		List<usermodel> signin = ps.userlist(dt.get("users").toString(), dt.get("password").toString());
		Map<String, String> data = new LinkedHashMap<>();

		if (signin.size() > 0) {
			data.put("Result", "Success Login");
			return ResponseEntity.status(HttpStatus.OK).body(data);
		}

		data.put("Result", "User / Password salah");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
	}
}
