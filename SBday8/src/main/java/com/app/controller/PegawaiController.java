package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.models.PegawaiModel;
import com.app.services.PegawaiService;

@Controller
public class PegawaiController {

	@Autowired
	private PegawaiService ps;

	@RequestMapping("listpegawai")
	// @ResponseBody
	public String ListPegawai(Model model) {

		List<PegawaiModel> data = ps.ListPegawai();
		model.addAttribute("hData", data);
		return "pegawai/List";
	}

	@RequestMapping("addpegawai")
	public String AddPegawai() {
		return "pegawai/add";
	}

	@RequestMapping(value = "addsimpan", method = RequestMethod.POST)
	public String AddSimpan(PegawaiModel pm) {
		ps.addPegawai(pm);
		return "redirect:/listpegawai";

	}
}