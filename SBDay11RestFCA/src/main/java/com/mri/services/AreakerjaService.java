package com.mri.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mri.models.Areakerja;
import com.mri.repo.AreakerjaRepo;

@Service
@Transactional
public class AreakerjaService {
	
	@Autowired
	private AreakerjaRepo ar;
	
	public List<Areakerja>listall(){
		return ar.findAll();
	}
}
