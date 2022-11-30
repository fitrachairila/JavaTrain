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
		return pr.findAll();
	}

	public void addPegawai(PegawaiModel pm) {
		pr.save(pm);
	}
}
