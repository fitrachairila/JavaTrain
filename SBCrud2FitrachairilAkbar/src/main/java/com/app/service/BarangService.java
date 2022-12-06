package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.models.BarangModel;
import com.app.repo.BarangRepo;

@Service
@Transactional
public class BarangService {
	@Autowired
	private BarangRepo br;

	public List<BarangModel> RBarang() {
		return br.RBarang();
	}

	public int totalBarang() {
		return br.totalbarang();
	}

	public void addBarang(BarangModel mm, String createdon) {
		br.addBarang(mm.getmNama(), mm.getmSupplier(), mm.getmQty(),createdon);
	}

	public void edtBarang(BarangModel edt) {
		br.edtBarang(edt.getId(), edt.getmNama(), edt.getmSupplier(), edt.getmQty());
	}

	// service del
	public void delBarang(BarangModel dm) {
		br.delBarang(dm.getId());
	}
	
	public List<BarangModel> Rbarang2(int id){
		return br.RBarang2(id);
	}
	
	public void edtBarang(int id, String nm, String sup, int qty, String modifiedon) {
		br.edtBarang(id, nm, sup, qty, modifiedon);
	}
}
