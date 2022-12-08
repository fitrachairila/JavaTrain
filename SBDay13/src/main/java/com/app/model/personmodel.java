package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="person") // Initiate nama tabel
public class personmodel {

		@Id
		private int id;
		private String nama;
		
		@ManyToOne
		@JsonIgnoreProperties("person")
		@JoinColumn(name = "idArea")
		private areamodel area;
		
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

		public areamodel getArea() {
			return area;
		}

		public void setArea(areamodel area) {
			this.area = area;
		}

}