package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.SbDay19Application;

@RestController
@RequestMapping("api/default")
public class DefaultCTRL {
	static String NewDir = SbDay19Application.NewDir;

	// Method Create Direktory
	@GetMapping("list")
	public ResponseEntity<Object> ListDir() {

		Map<String, String> data = new LinkedHashMap<>();
		File file = new File(NewDir);
		String[] filename = file.list();
		for (int i = 0; i < filename.length; i++) {
			data.put("File ke" + (i + 1) + " : ", filename[i]);
		}
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	@PostMapping("upload")
	public void upload(@RequestParam("uploadfile")MultipartFile[] uploadFiles) {
		System.out.println(NewDir);
		try {
			for (MultipartFile multipartFile : uploadFiles) {
				File file = new File(NewDir + multipartFile.getOriginalFilename());
				multipartFile.transferTo(file);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// Method Hapus File
	@DeleteMapping("Delete/{filename}")
	public ResponseEntity<Object> df(@PathVariable("filename") String filename) {
		Map<String, String> result = new LinkedHashMap<>();
		File file = new File(NewDir + filename);

		// Cek Apakah file ada dalam folder atau tidak
		if (file.exists() == true) {
			file.delete();
			result.put("Result : ", filename + ", di Hapus");
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			result.put("Result : ", filename + ", Tidak Ada");
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}

	}
}
