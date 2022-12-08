package com.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="areakerja")
public class areamodel {

	@Id
	private int id;
	private String lantai;
	
	@OneToMany(mappedBy = "area")
	@JsonIgnoreProperties("area")
	private List<personmodel> person;
	
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
	public List<personmodel> getPerson() {
		return person;
	}
	public void setPerson(List<personmodel> person) {
		this.person = person;
	}
	
}
