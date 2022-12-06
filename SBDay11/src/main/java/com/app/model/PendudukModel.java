package com.app.model;

import javax.validation.constraints.NotBlank;

public class PendudukModel {
		
		@NotBlank(message = "nama harus diisi")
		private String nama;
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
		
}

