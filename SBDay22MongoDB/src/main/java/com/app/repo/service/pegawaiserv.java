package com.app.repo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.pegawaimodel;
import com.app.repo.pegawairepo;

@Service
public class pegawaiserv {
	@Autowired
	private pegawairepo pr;

	public List<pegawaimodel> list() {
		return pr.findAll();
	}

	public void addpegawai(pegawaimodel pm) {
		pr.save(pm);
	}

	public Optional<pegawaimodel> findbyid(String id) {
		return pr.findById(id);
	}

	public void edtpegawai(pegawaimodel pm) {
		pr.save(pm);
	}

	public void delpegawai(pegawaimodel pm) {
		pr.delete(pm);
	}

	public void deleteBynama(String nama) {
		pr.deleteBynama(nama);
	}

	// Query
	public List<pegawaimodel> listpgw() {
		return pr.listpegawai();

	}

	public pegawaimodel carinama(String nama) {
		return pr.carinama(nama);
	}
	
	public pegawaimodel cariumur(Integer um) {
		return pr.cariumur(um);
	}


}
