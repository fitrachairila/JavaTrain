package com.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mPegawai")
public class PegawaiModel {

	@Id
	@Column(name = "idPegawai")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nama;
	private String Alamat;
	private int Umur;

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

	public String getAlamat() {
		return Alamat;
	}

	public void setAlamat(String alamat) {
		Alamat = alamat;
	}

	public int getUmur() {
		return Umur;
	}

	public void setUmur(int umur) {
		Umur = umur;
	}
	

}
