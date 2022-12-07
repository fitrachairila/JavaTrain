package com.mri.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class PendudukModel {
	
	@NotBlank(message = "nama harus di isi !")
	@Size(min = 5, message = "nama minimal 5 karakter")
	private String nama;
	
	@Min(value = 17, message = "umur minimal 18 Tahun")
	@Max(value = 55, message = "umur maksimal 55 Tahun")
	private int umur;
	private int gaji;
	
	@Email(regexp = ".+[@].+[\\.].+" , message = "format email salah, aaa@bbb.ccc")
	private String email;
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getUmur() {
		return umur;
	}
	public void setUmur(int umur) {
		this.umur = umur;
	}
	public int getGaji() {
		return gaji;
	}
	public void setGaji(int gaji) {
		this.gaji = gaji;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
