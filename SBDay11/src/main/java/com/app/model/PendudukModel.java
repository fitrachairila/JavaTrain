package com.app.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class PendudukModel {
		//Validation
		@NotBlank(message = "Nama Tidak Boleh Kosong!!") //Tidak Boleh Kosong
		@Size(min = 5, message = "Nama Minimal 5 Karakter") //Minimal Panjang Character 
		private String nama;
		
		@Min(value = 17, message = "Umur Minimal 17 Th") //minimal umur 17
		@Max(value = 55, message = "Umur Maksimal 55 Th")//maksimal umur 55
		private int umur;
		
		@Email(regexp=".+[@].+[\\.].+",message = "Format Email harus Benar!!")//validasi format email
		private String email;
		
		private String alamat;
		
		private int gaji;
		
		public String getNama() {
			return nama;
		}
		public void setNama(String nama) {
			this.nama = nama;
		}
		public String getAlamat() {
			return alamat;
		}
		public void setAlamat(String alamat) {
			this.alamat = alamat;
		}
		public int getGaji() {
			return gaji;
		}
		public void setGaji(int gaji) {
			this.gaji = gaji;
		}
		public int getUmur() {
			return umur;
		}
		public void setUmur(int umur) {
			this.umur = umur;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
}

