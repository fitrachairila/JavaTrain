package com.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mBarang")
public class BarangModel {

	@Id
	@Column(name = "idBarang")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mNama;
	private String mSupplier;
	private int mQty;
	private String mCreated;
	private String mMod;
	private String mdel;
	private String Users;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getmNama() {
		return mNama;
	}
	public void setmNama(String mNama) {
		this.mNama = mNama;
	}
	public String getmSupplier() {
		return mSupplier;
	}
	public void setmSupplier(String mSupplier) {
		this.mSupplier = mSupplier;
	}

	public String getmCreated() {
		return mCreated;
	}
	public void setmCreated(String mCreated) {
		this.mCreated = mCreated;
	}
	public String getmMod() {
		return mMod;
	}
	public void setmMod(String mMod) {
		this.mMod = mMod;
	}
	public String getMdel() {
		return mdel;
	}
	public void setMdel(String mdel) {
		this.mdel = mdel;
	}
	public int getmQty() {
		return mQty;
	}
	public void setmQty(int mQty) {
		this.mQty = mQty;
	}
	public String getUsers() {
		return Users;
	}
	public void setUsers(String users) {
		this.Users = users;
	}
	
}
