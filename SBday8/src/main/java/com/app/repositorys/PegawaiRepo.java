package com.app.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.models.PegawaiModel;

public interface PegawaiRepo extends JpaRepository<PegawaiModel, Integer> {
	//Select, update, Instert
	List<PegawaiModel>findAllByOrderById();
	
	//JPQL
	@Query(value = "select p from PegawaiModel p")
	List<PegawaiModel>ListPegawai();
	
	//JPQL Native
	@Query(value = "select * from m_pegawai order by id_pegawai Asc", nativeQuery=true)
	List<PegawaiModel>Pegawi();
	
	//Insert From Back end
	@Modifying
	@Query(value = "insert into m_pegawai(nama,alamat,umur)" + "values(?1,?2,?3)", nativeQuery=true)
	void addPegawai(String nm,String al,int um);
	
	@Modifying
	@Query(value = "update m_pegawai set nama=:nm, alamat=:al, umur=:um where id_pegawai=:id", nativeQuery = true)
	void editPegawai(String nm, String al, int um, int id);
	
	@Modifying
	@Query(value = "delete from m_pegawai where id_pegawai=:id", nativeQuery = true)
	void delPegawai(int id);
	
	@Query(value = "select count(nama) from m_pegawai", nativeQuery = true)
	int totalPegawai();
}
