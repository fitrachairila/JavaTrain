package com.app.services;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.PegawaiModel;
import com.app.repositorys.PegawaiRepo;

@Service
@Transactional
public class PegawaiService {

	@Autowired
	private PegawaiRepo pr;

	public List<PegawaiModel> ListPegawai() {
		// return pr.findAll();
		// return pr.findAllByOrderById();
		// return pr.ListPegawai(); //JPQL
		return pr.Pegawi(); // JPQL NATIVE
		// return pr.addmodpgw();
	}

	public void addPegawai(PegawaiModel pm) {
		// pr.save(pm);
		pr.addPegawai(pm.getNama(), pm.getAlamat(), pm.getUmur());
	}

	public void editPegawai(PegawaiModel pm) {
		// .out.println(pm.getId());
		// pr.save(pm);
		pr.editPegawai(pm.getNama(), pm.getAlamat(), pm.getUmur(), pm.getId());
	}

	// service del
	public void delPegawai(PegawaiModel pm) {
		// pr.delete(pm);
		pr.delPegawai(pm.getId());
	}

	// Service View Data
	public int totalPegawai() {
		return pr.totalPegawai();
	}
}