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
		int totPegawai = ps.totalPegawai();
		model.addAttribute("hData", data);
		model.addAttribute("hTPegawai", totPegawai);
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

	@RequestMapping(value = "edtsimpan", method = RequestMethod.POST)
	public String edtsimpan(PegawaiModel pm) {
		if (pm.getUsers().equalsIgnoreCase("")) {
		} else {
			ps.editPegawai(pm);
		}
		return "redirect:/listpegawai";
	}

	// delete control
	@RequestMapping(value = "delpegawai", method = RequestMethod.POST)
	public String DelSimpan(PegawaiModel pm) {
		if (pm.getUsers().equalsIgnoreCase("")) {
		} else {
			ps.delPegawai(pm);
		}
		return "redirect:/listpegawai";
	}
}