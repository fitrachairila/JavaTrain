package com.mri.ControllerRest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mri.models.PendudukModel;

@RestController
@RequestMapping(value = "api/v1/")
public class DefaultController {
	
	@GetMapping(value = "nama1")
	public String nama1() {
		String nama = "Bruce Wils";
		return nama;
	}
	
	@GetMapping(value = "nama2")
	public Map<String, String> nama2() {
		// buat collection map
		Map<String, String> data = new LinkedHashMap<>();
		data.put("Nama", "Xavier");
		return data;
	}
	
	@GetMapping(value = "nama3")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Map<String, String> nama3() {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("Nama", "Xavier");
		return data;
	}
	
	@GetMapping(value = "nama4")
	public ResponseEntity<Object> nama4ResponseEntity() {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("Nama", "Xavier");
		return ResponseEntity.status(HttpStatus.CREATED).body(data);
	}
	
	@GetMapping(value = "nilai1")
	public int nilai1() {
		int nilai = 1500;
		return nilai;
	}
	
	// DENGAN PARAMETER //
	
	@PostMapping(value = "postdata1")
	public void receiveData(
		@RequestParam(name = "nama")String nm,
		@RequestParam(name = "umur")int um
	) {
		System.out.println(nm);
		System.out.println(um);
	}
	
	@PostMapping(value = "postdata2/{kelas}")
	public void receiveData2(
		@PathVariable(name = "kelas")String kl
	) {
		System.out.println(kl);
	}
	
	@PostMapping(value = "postdata3")
	public void receiveData3(
		@RequestBody Map<String, Object> data
	) {
		System.out.println(data.get("nama"));
		System.out.println(data.get("umur"));
		System.out.println(data.get("gaji"));
	}
	
	@PostMapping(value = "postdata3new")
	public ResponseEntity<Object> kelulusan2(
		@RequestBody Map<String, Object> data
	) {
		String nama = String.valueOf(data.get("nama"));
		if(nama.equalsIgnoreCase("")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nama Tidak Boleh Kosong");
		}else{
			return ResponseEntity.status(HttpStatus.OK).body("success");
		}
	}
	
	@PostMapping(value = "postdata4")
	public ResponseEntity<Object> receiveData4(
		@Valid @RequestBody PendudukModel pm,
		BindingResult br
	) {
		//System.out.println(br);
		if(br.hasErrors()) {
			//System.out.println(br.getFieldError().getDefaultMessage());
			//String err = br.getFieldError().getDefaultMessage(); // SINGLE ERROR
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
			
			List<FieldError> errors = br.getFieldErrors();
			List<String > hErr = new ArrayList<>();
			for(FieldError fieldError : errors) {
				//System.out.println(fieldError.getDefaultMessage());
				hErr.add(fieldError.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hErr);
		}else {
			System.out.println(pm.getNama());
			System.out.println(pm.getUmur());
			System.out.println(pm.getGaji());
			System.out.println(pm.getEmail());
			return ResponseEntity.status(HttpStatus.OK).body("Success");
		}
	}
	
	/* LATIHAN 1 */
	@PostMapping(value = "latihan1")
	public ResponseEntity<Map<String, String>> Latihan1(
		@RequestBody Map<String, Object> data
	) {
		String hasil = data.get("Hasil").toString().toUpperCase();
		if(hasil.equals("LULUS")) {
			Map<String, String> m = new LinkedHashMap<>();
			m.put("body", data.get("Nama").toString() + " Score di atas 60");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(m);
		}else{
			Map<String, String> m = new LinkedHashMap<>();
			m.put("body", data.get("Nama").toString() + " Score di bawah 60");
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(m);
		}
	}
	
	/* Jawaban Mas Rizky Putra */
	@PostMapping(value = "kelulusan")
	public ResponseEntity<Object> kelulusan(
		@RequestBody Map<String, String> data
	) {
		String Hasil = data.get("hasil");
		if(Hasil.equals("Lulus")) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(data.get("nama") + ", Score di atas 60");
		}else{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(data.get("nama") + ", Score di bawah 60");
		}
	}
}
