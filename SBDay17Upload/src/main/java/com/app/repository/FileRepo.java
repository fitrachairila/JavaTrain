package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.FileModel;

public interface FileRepo extends JpaRepository<FileModel, Integer>{
	FileModel findByfilename(String fn);
	
}
