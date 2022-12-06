package com.app.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	String dateNow = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
	String timeNow = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

	// View List Barang & Jumlah Barang
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

	// Simpan Barang Baru
	@RequestMapping(value = "addSimpan", method = RequestMethod.POST)
	public String AddSimpan(BarangModel sv) {
		String createdon = dateNow + " " + timeNow;
		bs.addBarang(sv, createdon);
		return "redirect:/listbarang";
	}
	
	// Delete Barang
	@RequestMapping(value = "DeleteBarang", method = RequestMethod.POST)
	public String Delsimpan(BarangModel dm) {
		bs.delBarang(dm);
		return "redirect:/listbarang";
	}

	// Edit Barang
	//@RequestMapping("EditBarang")
	//public String EditBarang() {
		//return "Barang/edit";
	//}

	// Halaman Edit Barang
	@RequestMapping(value = "editbarang", method = RequestMethod.POST)
	public String edtBarang(BarangModel edt, Model m) {
		List<BarangModel> lebarang = bs.Rbarang2(edt.getId());
		String Page = " ";
		if(lebarang.size()>0) {
			m.addAttribute("lebarang", lebarang);
			Page = "barang/edit";
		}else {
			Page = "redirect:/listbarang";
		}
		return Page;
	}
	/*-=Update Barang=-*/
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edtBarang(BarangModel bm) {
		String modifiedon = dateNow + " " + timeNow;
		bs.edtBarang(bm.getId(), bm.getmNama(), bm.getmSupplier(), bm.getmQty(), modifiedon);
		return "redirect:/listbarang";
	}

}