package com.app.ctrl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.FileModel;
import com.app.service.FileService;

@RestController
@RequestMapping("api/file2")
public class FileToDBCTRL {

	@Autowired
	private FileService fs;

	@GetMapping("list")
	public ResponseEntity<Object> list() {
		return ResponseEntity.status(HttpStatus.OK).body(fs.list());
	}

	@PostMapping("upload")
	public void upload(@RequestParam("uploadfile") MultipartFile[] uploadfile) throws IOException {


		// Upload lebih dari 1 file
		for (int i = 0; i < uploadfile.length; i++) {
			FileModel fm = new FileModel();
			fm.setFilename(uploadfile[i].getOriginalFilename());
			fm.setFile(uploadfile[i].getBytes());
			fs.save(fm);
		}

	}

	@GetMapping("view/{filename}")
	public ResponseEntity<Object> view(@PathVariable("filename") String filename) {
		byte[] image = new byte[0];
		image = fs.view(filename).getFile();
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.IMAGE_JPEG).body(image);
	}
}
