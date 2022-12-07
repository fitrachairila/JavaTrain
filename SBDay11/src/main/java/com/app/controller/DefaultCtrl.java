package com.app.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.validation.Valid;

import org.hibernate.mapping.Array;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.*;

@RestController
@RequestMapping(value = "api/v1/")
public class DefaultCtrl {

	@GetMapping(value = "nama1")
	public String nama1() {
		String nama = "kimbe";
		return nama;
	}

	@GetMapping(value = "nilai1")
	public int nilai1() {
		int nilai = 1500;
		return nilai;
	}

	@GetMapping(value = "nama2")
	public Map<String, String> nama2() {
		// {
		// "nama" :"kenzier"
		// }
		Map<String, String> data = new LinkedHashMap<>();
		data.put("Nama", "Kimbe lagi");
		return data;
	}

	@GetMapping(value = "nama3")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Map<String, String> nama3httpstatus() {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("Nama", "Kimbe lagi");
		return data;
	}

	@GetMapping(value = "nama4")
	@ResponseStatus(code = HttpStatus.FOUND)
	public ResponseEntity<Object> nama4respons() {
		Map<String, String> data = new LinkedHashMap<>();
		data.put("Nama", "Kimbe lagi");
		return ResponseEntity.status(HttpStatus.CREATED).body(data);
	}

	// set http status
	@GetMapping(value = "nilai3")
	@ResponseStatus(code = HttpStatus.OK)
	public Map<String, Integer> nilai3() {
		// collection
		Map<String, Integer> data = new LinkedHashMap<>();
		data.put("Hasil", 100);
		return data;
	}

	@GetMapping(value = "nilai4")
	public ResponseEntity<Object> nilai4() {
		Map<String, Integer> data = new LinkedHashMap<>();
		data.put("Hasil", 100);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
	}

	@PostMapping(value = "getdata1")
	public void getData(@RequestParam(value = "nama") String nm, @RequestParam(value = "nilai") int ni) {
		System.out.println(nm + " " + ni);
	}

	@PostMapping(value = "getdata2")
	public void getData2(@PathVariable(name = "kelas") String kl) {
		System.out.println(kl);
	}

	@PostMapping(value = "getdata3")
	public void getData3(@RequestBody Map<String, Object> data) {
		System.out.println(data.get("nama"));
		System.out.println(data.get("umur"));
		System.out.println(data.get("gaji"));
		
	}

	//Post API
	@PostMapping(value = "getdata4")
	public ResponseEntity<Object> getData4(@Valid @RequestBody PendudukModel pm,
			BindingResult br) {
		
		//Catch Error Message From API
		//Single Field
//		if(br.hasErrors() ) {
//			String errmsg = br.getFieldError().getDefaultMessage();
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errmsg);
//		}
		
		//Catch Error Message From API
		// List From All Error
		if (br.hasErrors()) {
			List<FieldError> error = br.getFieldErrors();
			List<String> errmsg =  new ArrayList<>();
			
			for(FieldError fieldError : error) {
				errmsg.add(fieldError.getDefaultMessage());	
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errmsg);
		}
		System.out.println(pm.getNama());
		System.out.println(pm.getUmur());
		System.out.println(pm.getGaji());
		System.out.println(pm.getAlamat());
		System.out.println(pm.getEmail());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Succes");
	}

	@PostMapping(value = "ceknilai")
	public ResponseEntity<Object> cekNilai(@RequestBody Map<String, Integer> reqData) {
		int nilai = reqData.get("nilai");

		Map<String, String> hasil = new LinkedHashMap<>();
		if (nilai > 60) {
			hasil.put("Hasil", "Anda Lulus");
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(hasil);
		} else {
			hasil.put("Hasil", "Silahkan mengulang !!");
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(hasil);
		}
	}

}
