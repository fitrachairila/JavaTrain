package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.models.BarangModel;
import com.app.service.BarangService;

@Controller
public class BarangController {
	@Autowired
	private BarangService bs;
	
	//View List Barang & Jumlah Barang
	@RequestMapping("listbarang")
	public String ListBarang(Model m) {
		int total = bs.totalBarang();
		List<BarangModel> data = bs.RBarang();
		m.addAttribute("hData", data);
		m.addAttribute("hTBarang", total);
		return "barang/list";
	}
	
	@RequestMapping("addbarang")
	public String AddBarang() {
		return "Barang/add";
	}
	
	//Simpan Barang Baru
	@RequestMapping(value = "addSimpan", method = RequestMethod.POST)
	public String AddSimpan(BarangModel sv) {
		bs.addBarang(sv);
		return "redirect:/listbarang";
}
	//Edit Barang
	@RequestMapping("EditBarang")
	public String EditBarang() {
		return "Barang/edit";
	}
	
	@RequestMapping(value = "edtBarang", method = RequestMethod.POST)
	public String edtBarang(BarangModel edt) {
	bs.edtBarang(edt);
	return "redirect:/listbarang";
}
	
	@RequestMapping(value = "DeleteBarang", method =RequestMethod.POST)
	public String Delsimpan(BarangModel dm) {
		bs.delPegawai(dm);
		return "redirect:/listbarang";
}
}