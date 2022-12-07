package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mAreaKerja")
public class AreakerjaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lantai;
	
	@OneToOne(mappedBy = "areakerjamodel")
	@JsonIgnoreProperties("areakerjamodel")
	private PersonModel personmodel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLantai() {
		return lantai;
	}

	public void setLantai(String lantai) {
		this.lantai = lantai;
	}

	public PersonModel getPerson() {
		return personmodel;
	}

	public void setPerson(PersonModel person) {
		this.personmodel = person;
	}
}