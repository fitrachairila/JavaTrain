package com.app.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.DTOperson;
import com.app.model.personmodel;

public interface personrepo extends JpaRepository<personmodel, Integer>{

	@Query(value = "select id,nama from person",nativeQuery = true)
	List<Map<String, Object>>listperson();
	
	@Query(value = "select id,nama from person",nativeQuery = true)
	List<DTOperson>listperson2();
	
	@Query(value = "select nama,lantai from person join areakerja on person.id_area=areakerja.id",nativeQuery = true)
	List<Map<String, Object>>personarea();
}
