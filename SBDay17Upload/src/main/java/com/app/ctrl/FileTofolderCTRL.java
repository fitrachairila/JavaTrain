package com.app.ctrl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
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

import com.app.SbDay17Application;

@RestController
@RequestMapping("api/file1")
public class FileTofolderCTRL {

	static String NewDir = SbDay17Application.NewDir;

	// Method Create Direktory
	@GetMapping("list")
	public ResponseEntity<Object> ListDir() {

		Map<String, String> data = new LinkedHashMap<>();
		File file = new File(NewDir);
		String[] filename = file.list();
		for (int i = 0; i < filename.length; i++) {
			data.put("File ke" + (i + 1) + " : ", filename[i]);
		}
		// File 1 : way.txt
		// File 2 : list.txt
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}

	// Method Upload File
	@PostMapping("upload")
	public void upload(@RequestParam("uploadfile") MultipartFile uf) {
		// System.out.println(uf);

		File file = new File(NewDir + uf.getOriginalFilename());
		try {
			uf.transferTo(file);
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

	// Method view gambar
	@GetMapping("view/{filename}")
	public ResponseEntity<Object> view(@PathVariable("filename") String filename) throws IOException {
		byte[] image = new byte[0];

		// Get File
		Path path = Paths.get(NewDir + filename);
		// baca image sebagai byte
		image = Files.readAllBytes(path);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(image);
	}
}
