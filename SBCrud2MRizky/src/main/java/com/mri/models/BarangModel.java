package com.mri.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mBarang")
public class BarangModel {
	
	@Id
	@Column(name="idBarang")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nama_barang;
	private String supplier;
	private int qty;
	private String created_on;
	private String modified_on;
	private String delete_on;
	
	/*-=Getter Setter=-*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama_barang() {
		return nama_barang;
	}
	public void setNama_barang(String nama_barang) {
		this.nama_barang = nama_barang;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public String getModified_on() {
		return modified_on;
	}
	public void setModified_on(String modified_on) {
		this.modified_on = modified_on;
	}
	public String getDelete_on() {
		return delete_on;
	}
	public void setDelete_on(String delete_on) {
		this.delete_on = delete_on;
	}
}
