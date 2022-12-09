package com.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.model.barangmodel;
import com.app.service.barangserv;

@Controller
public class barangcontroller {

	@Autowired
	private barangserv bs;

	@GetMapping(value = "baranglist")
	public ResponseEntity<Object> baranglist() {
		return ResponseEntity.status(HttpStatus.OK).body(bs.baranglist());
	}

	@PostMapping(value = "barangadd")
	public ResponseEntity<Object> barangadd(@RequestBody Map<String, Object> dt) {
		try {
			String nama_barang = dt.get("nama_barang").toString();
			int id_supplier = Integer.parseInt(dt.get("id_supplier").toString());
			int qty = Integer.parseInt(dt.get("qty").toString());
			
			bs.barangadd(id_supplier, nama_barang, qty);
			return ResponseEntity.status(HttpStatus.CREATED).body("Tambah Barang Berhasil");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tambah Barang Gagal, ID Barang Tidak Ada");
		}
	}

	@PostMapping(value = "barangedit")
	public ResponseEntity<Object> barangedit(
		@RequestBody Map<String, Object> dt
	) {
		try {
			int idbarang = Integer.parseInt(dt.get("id").toString());
			String nama_barang = dt.get("nama_barang").toString();
			int id_supplier = Integer.parseInt(dt.get("id_supplier").toString());
			int qty = Integer.parseInt(dt.get("qty").toString());
			
			List<barangmodel>CheckIdBarang=bs.CheckIdBarang(idbarang);
			if(CheckIdBarang.size()>0) {
			
				List<barangmodel>CheckIdSupplier=bs.CheckIdSupplier(id_supplier);
				if(CheckIdSupplier.size()>0) {
					
					bs.barangedit(id_supplier, nama_barang, qty);
					return ResponseEntity.status(HttpStatus.ACCEPTED).body("Edit Barang Berhasil");
					
				}else{
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Edit Barang Gagal, Id Supplier Tidak Ada");
				}
				
			}else{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Edit Barang Gagal, Id Barang Tidak Ada");
			}
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Edit Barang Gagal, " + e.getMessage());
		}
	}
	
	@PostMapping(value = "barangdelete")
	public ResponseEntity<Object> barangdelete(
		@RequestBody Map<String, Object> dt
	) {
		try {
			int id = Integer.parseInt(dt.get("id").toString());
			List<barangmodel>CheckIdBarang=bs.CheckIdBarang(id);
			if(CheckIdBarang.size()>0) {
				
				bs.barangdelete(id);
				return ResponseEntity.status(HttpStatus.OK).body("Delete Barang Berhasil");
				
			}else{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Barang Gagal, Id Barang Tidak Ada");
			}
			
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Delete Barang Gagal, " + e.getMessage());
		}
	}
}