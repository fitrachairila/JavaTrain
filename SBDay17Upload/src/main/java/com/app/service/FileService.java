package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.app.repository.FileRepo;
import com.app.model.FileModel;

@Service
@Transactional
public class FileService {

	@Autowired
	private FileRepo fr;

	public List<FileModel> list() {
		return fr.findAll();
	}

	public void save(FileModel fm) {
		fr.save(fm);
	}
	
	public FileModel view(String fn) {
		return fr.findByfilename(fn);
	}
}
