package com.mri.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nama;
	
	@OneToOne
	@JsonIgnoreProperties("person")
	@JoinColumn(name = "id_areakerja") // foreign key
	private Areakerja areakerja; // entity rujukan

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

	public Areakerja getAreakerja() {
		return areakerja;
	}

	public void setAreakerja(Areakerja areakerja) {
		this.areakerja = areakerja;
	}
}
