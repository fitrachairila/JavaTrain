package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontEndController {
//
	@RequestMapping("page1")
	public String page1() {
		return "FrontEnd/htmlCSS";
	}
}
