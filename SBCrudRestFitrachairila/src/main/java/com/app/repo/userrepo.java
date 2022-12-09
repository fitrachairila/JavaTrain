package com.app.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.usermodel;

public interface userrepo extends JpaRepository<usermodel, Integer> {
	
	@Query(value = "select * from Tuser"
			+ " where users=:users and password=:password", nativeQuery = true)
	List<usermodel> userlist(String users, String password);
}
