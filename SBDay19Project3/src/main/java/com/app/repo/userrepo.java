package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.usermodel;

public interface userrepo extends JpaRepository<usermodel, Integer>{
	
}
