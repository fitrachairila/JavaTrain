package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "mPerson")
public class PersonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nama;
//	private int idAreakerja;
	
	@OneToOne
	@JsonIgnoreProperties("PersonModel")
	@JoinColumn(name = "id_areakerja")//foreign key
	private AreakerjaModel areakerjamodel; //entity rujukan

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public AreakerjaModel getAreakerja() {
		return areakerjamodel;
	}

	public void setAreakerja(AreakerjaModel areakerja) {
		this.areakerjamodel = areakerja;
	}
	
}
