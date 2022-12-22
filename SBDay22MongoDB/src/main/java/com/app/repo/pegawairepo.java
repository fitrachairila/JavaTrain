package com.app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.pegawaimodel;

public interface pegawairepo extends MongoRepository<pegawaimodel, String> {

   //Query			
   void deleteBynama(String nama);

	@Query(value = "{}", sort = "{umur:-1}")
	List<pegawaimodel>listpegawai();
	

	@Query(value = "{nama:?0}")
	pegawaimodel carinama(String nama); 	
	
	@Query(value = "{umur: :#{#um}}")
	pegawaimodel cariumur(@Param("um")Integer um);
	
}