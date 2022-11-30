package com.app.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.models.PegawaiModel;

public interface PegawaiRepo extends JpaRepository<PegawaiModel, Integer> {

	
}
