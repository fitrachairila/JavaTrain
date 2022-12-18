package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.SbDay19Application;
import com.app.config.MailConfig;
import com.app.model.DTOMail;
import com.app.model.usermodel;
import com.app.service.userserv;

@RestController
@RequestMapping("api/default")
public class DefaultCTRL {
	@Autowired
	private MailConfig MailConf;
	
	@Autowired
	private userserv serv;
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

	// Method Upload File
	@PostMapping("upload")
	public ResponseEntity<Object> upload(@RequestParam("uploadfile") MultipartFile[] uploadFiles) {
		System.out.println(NewDir);
		try {
			for (MultipartFile multipartFile : uploadFiles) {
				Map<String, String> result = new LinkedHashMap<>();
				File path = new File(NewDir + multipartFile.getOriginalFilename());
				File nfile = new File(multipartFile.getOriginalFilename());
				multipartFile.transferTo(path);
				result.put("Result : ", nfile + ", Succes Di Upload");

				String subject = "Notifikasi Upload File";
				String body = nfile + " Succes Di Upload!";
				ParmKirimEmail(subject, body);

				return ResponseEntity.status(HttpStatus.OK).body(result);
			}
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	// Method Delete File
	@DeleteMapping("Delete/{filename}")
	public ResponseEntity<Object> df(@PathVariable("filename") String filename) {
		Map<String, String> result = new LinkedHashMap<>();
		File file = new File(NewDir + filename);
		System.out.println(filename);
		String subject = "Notifikasi Delete File";
		String body = filename + " Succes Di Delete!";

		// Cek Apakah file ada dalam folder atau tidak
		if (file.exists() == true) {
			file.delete();
			result.put("Result : ", filename + ", Succes Di Delete!");
			ParmKirimEmail(subject, body);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			result.put("Result : ", filename + ", Tidak Ditemukan");
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	}

	// Method Mengisi Parameter Kirim Email
	private void ParmKirimEmail(String subject, String body) {
		List<usermodel> listUser = serv.listUser();
		for (usermodel users : listUser) {
			String to = users.getEmail();
			MailConf.send(to, subject, body);
		}
	}
}
