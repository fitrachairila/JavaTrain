package com.app.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/")
public class DefaultRestControl {

	@GetMapping(value = "nama1")
	public String nama1() {
		String nama = "Warga";
		return nama;
	}

	@GetMapping(value = "nilai1")
	public int nilai1() {
		int nilai = 100;
		return nilai;
	}

	@GetMapping(value = "nilai2")
	public Map<String, Integer> nilai2() {
		// collection
		Map<String, Integer> data = new LinkedHashMap<>();

		data.put("Hasil", 100);

		return data;
	}

	// set http status
	@GetMapping(value = "nilai3")
//	@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
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

//		return new ResponseEntity<>(data, HttpStatus.CREATED);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
	}

	@PostMapping(value = "senddata1")
	public void getData(@RequestParam(value = "nama") String nm, @RequestParam(value = "nilai") int ni) {
		System.out.println(nm + " " + ni);
	}

	@PostMapping(value = "senddata2")
	public void getData2(@PathVariable(name = "kelas") String kl) {
		System.out.println(kl);
	}

	@PostMapping(value = "senddata3")
	public void getData3(@RequestBody Map<String, Object> data) {
		System.out.println(data.get("nama"));
		System.out.println(data.get("alamat"));
		System.out.println(data.get("umur"));
	}
	
	@PostMapping(value = "senddata4")
	public void getData4(@RequestBody PendudukModel pm) {
		System.out.println(pm.getNama());
		System.out.println(pm.getAlamat());
	}

	@PostMapping(value = "ceknilai")
	public ResponseEntity<Object> cekNilai(@RequestBody Map<String, Integer> reqData) {
		int nilai = reqData.get("nilai");

		Map<String, String>hasil = new LinkedHashMap<>();

		if(nilai > 60) {
			hasil.put("Hasil", "Anda Lulus");		
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(hasil);
		} else {
			hasil.put("Hasil", "Silahkan mengulang !!");		
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(hasil);
		}
	}
	
}
