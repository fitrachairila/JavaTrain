package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Latihan2_Day5 {

	@RequestMapping("Pegawai")
	public String Pegawai() {
		System.out.println("Halaman Pegawai Diakses");
		return "Pegawai";
	}

}
