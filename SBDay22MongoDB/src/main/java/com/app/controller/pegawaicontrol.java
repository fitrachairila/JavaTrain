package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.pegawaimodel;
import com.app.repo.service.pegawaiserv;


@RestController
@RequestMapping("api/pgw/")
public class pegawaicontrol {

	@Autowired
	private pegawaiserv ps ;
	
	@GetMapping("list")
	public List<pegawaimodel>list(){
		return ps.list();
	}
	
	@PostMapping("listby-id")
	public Optional<pegawaimodel>findbyid(@RequestBody pegawaimodel pm){
		return ps.findbyid(pm.getId());
	}
	
	@PostMapping("add")
	public void addpegawai(@RequestBody pegawaimodel pm) {
		ps.addpegawai(pm);
	}
	
	@PutMapping("edt")
	public void editpegawai(pegawaimodel pm) {
		ps.edtpegawai(pm);
	}
	
	@DeleteMapping("del")
	public void deletepegawai(pegawaimodel pm) {
		ps.delpegawai(pm);
	}
	
	//Query
	@GetMapping("List-ByQuery")
	public List<pegawaimodel>listpgw() {
		return ps.list();
	}
	
	@DeleteMapping("Del-byname")
	public String deletebyname(@RequestBody pegawaimodel pm) {
		try {
			ps.deleteBynama(pm.getNama());
			return "Delete Success";
		} catch (Exception e) {
			// TODO: handle exception
		} return "Delete Gagal";
	}

	@GetMapping("ListbyName/{nama}")
	public pegawaimodel carinama(@PathVariable String nama) {
		return ps.carinama(nama);
	}
	
	@GetMapping("ListbyUmur/{umur}")
	public pegawaimodel cariumur(@PathVariable Integer umur	) {
		return ps.cariumur(umur);
	}
}
