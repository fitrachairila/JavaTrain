package com.app.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.barangmodel;
import com.app.repo.barangrepo;

@Service
@Transactional
public class barangserv {

	@Autowired
	private barangrepo br;

	public List<Map<String, Object>> baranglist() {
		return br.baranglist();
	}

	public void barangadd(int idsup, String nmb, int qt) {
		br.barangadd(idsup, nmb, qt);
	}

	public void barangedit(int idsup, String nmb, int qt) {
		br.barangedit(idsup, nmb, qt);
	}
	
	public void barangdelete(int id) {
		br.barangdelete(id);
	}
	
	public List<barangmodel> CheckIdBarang(int id) {
		return br.CheckIdBarang(id);
	}
	
	public List<barangmodel> CheckIdSupplier(int id) {
		return br.CheckIdSupplier(id);
	}
}