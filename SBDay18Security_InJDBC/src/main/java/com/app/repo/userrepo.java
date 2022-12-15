package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.usermodel;

public interface userrepo extends JpaRepository<usermodel, Integer>{

}
