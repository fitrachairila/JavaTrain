package com.mri.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mri.models.BarangModel;
import com.mri.services.BarangService;

@Controller
public class BarangController {
	
	@Autowired
	private BarangService bs;
	
	String dateNow = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
    String timeNow = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	
	/*-=List Barang=-*/
	@RequestMapping("listbarang")
	public String ListBarang(Model m) {
		
		List<BarangModel>lBarang=bs.lBarang();
		int tBarang=bs.tBarang();

		m.addAttribute("lBarang", lBarang);
		m.addAttribute("tBarang", tBarang);
		return "barang/list";
	}
	
	/*-=Add Barang=-*/
	@RequestMapping("addbarang")
	public String AddBarang() {
		return "barang/add";
	}
	
	/*-=Simpan Barang=-*/
	@RequestMapping(value = "addbarang", method = RequestMethod.POST)
	public String addBarang(BarangModel bm) {
        String createdon = dateNow + " " + timeNow;
		bs.addBarang(bm, createdon);
		return "redirect:/listbarang";
	}
	
	/*-=Delete Barang=-*/
	@RequestMapping(value = "delbarang", method = RequestMethod.POST)
	public String delBarang(BarangModel bm) {
		bs.delBarang(bm);
		return "redirect:/listbarang";
	}
	
	/*-=Halaman Edit Barang=-*/
	@RequestMapping("edtbarang")
	public String EdtBarang(BarangModel bm, Model m) {
		List<BarangModel>leBarang=bs.leBarang(bm.getId());
		String page = "";
		if(leBarang.size()>0) {
			m.addAttribute("leBarang", leBarang);
			page = "barang/edit";
		}else {
			page = "redirect:/listbarang";
		}
		return page;
	}
	
	/*-=Update Barang=-*/
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String edtBarang(BarangModel bm) {
		String modifiedon = dateNow + " " + timeNow;
		bs.edtBarang(bm.getId(), bm.getNama_barang(), bm.getSupplier(), bm.getQty(), modifiedon);
		return "redirect:/listbarang";
	}
}
