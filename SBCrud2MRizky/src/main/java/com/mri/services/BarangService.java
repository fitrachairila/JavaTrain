package com.mri.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mri.models.BarangModel;
import com.mri.repositorys.BarangRepo;

@Service
@Transactional
public class BarangService {
	
	@Autowired
	private BarangRepo br;
	
	public List<BarangModel>lBarang(){
		return br.lBarang();
	}
	
	public int tBarang() {
		return br.tBarang();
	}
	
	public void addBarang(BarangModel bm, String createdon) {
		br.addBarang(bm.getNama_barang(), bm.getSupplier(), bm.getQty(), createdon);
	}
	
	public void delBarang(BarangModel bm) {
		br.delBarang(bm.getId());
	}
	
	public List<BarangModel> leBarang(int id) {
		return br.leBarang(id);
	}
	
	public void edtBarang(int id, String nb, String sp, int qt, String modifiedon) {
		br.edtBarang(id, nb, sp, qt, modifiedon);
	}
}
