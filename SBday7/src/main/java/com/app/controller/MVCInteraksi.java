package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MVCInteraksi {

	// View Value
	@RequestMapping("mvc1")
	public String mvc1(Model model) {
		String Nama = "Fitra Chairil Akbar";
		String Alamat = "Bogor";
		int Umur = 26;

		model.addAttribute("hNama", Nama);
		model.addAttribute("hAlamat", Alamat);
		model.addAttribute("hUmur", Umur);
		return "mvc1";
	}

	// Input Value From Front End
	@RequestMapping("mvc2")
	public String mvc2(@RequestParam(value = "nama", required = false, defaultValue = "") String nm,
			@RequestParam(value = "alamat", required = false, defaultValue = "") String am,
			@RequestParam(value = "umur", required = false, defaultValue = "") String um) {
		System.out.println(nm + " " + am + " " + " " + um + " ");
		return "mvc2";
	}
	
	@RequestMapping("mvc3")
	public String mvc3(Model model,@RequestParam(value = "nama", required = false, defaultValue = "") String nm,
			@RequestParam(value = "alamat", required = false, defaultValue = "") String am,
			@RequestParam(value = "umur", required = false, defaultValue = "") String um) {
		System.out.println(nm + " " + am + " " + " " + um + " ");
		
		model.addAttribute("hvnama", nm);
		model.addAttribute("hvalamat", am);
		model.addAttribute("hvumur", um);
		return "mvc3";
	}
	
	@RequestMapping("mvc4/{nama}/{alamat}/{umur}")
	public String mvc4(@PathVariable String nm,
						@PathVariable String am,
						@PathVariable String um) {
		System.out.println(nm + " " + am + " " + " " + um + " ");
		
		//model.addAttribute("hvnama", nm);
		///model.addAttribute("hvalamat", am);
		//model.addAttribute("hvumur", um);
		return "mvc4";
	}
	
	@RequestMapping("mvc5")
	public String mvc5(Model model){
		String[]nama={"Sena","Shiena","Akbar"};
		String[]alamat={"Cianjur","Jakarta","Bogor"};
		String[]umur={"29","22","26"};
		int[]tahun = {2010,2011,2012};
		String gender = "pria";
		model.addAttribute("hnama",nama);
		model.addAttribute("halamat",alamat);
		model.addAttribute("hgender",gender);
		model.addAttribute("hthlulus", tahun);
		return "mvc5";
	}
}
