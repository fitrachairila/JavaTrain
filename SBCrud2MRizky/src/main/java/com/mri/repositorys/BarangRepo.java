package com.mri.repositorys;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.mri.models.BarangModel;

public interface BarangRepo extends JpaRepository<BarangModel,Integer> {
	
	/*-=List Barang=-*/
	@Query(value="select * from m_barang order by id_barang asc", nativeQuery = true)
	List<BarangModel>lBarang();
	
	/*-=Total Barang=-*/
	@Query(value="select sum(qty) from m_barang",nativeQuery = true)
	int tBarang();
	
	/*-=Add Barang=-*/
	@Modifying
	@Query(value="insert into m_barang (nama_barang, supplier, qty, created_on)"
			+ "values(?1,?2,?3,?4)", nativeQuery = true)
	void addBarang(String nb,  String sp, int qt, String createdon);
	
	/*-=Delete Barang=-*/
	@Modifying
	@Query(value="delete from m_barang where id_barang=:id", nativeQuery = true)
	void delBarang(int id);
	
	/*-=List Edit Barang=-*/
	@Query(value="select * from m_barang where id_barang=:id", nativeQuery = true)
	List<BarangModel>leBarang(int id);
	
	/*-=Update Barang=-*/
	@Modifying
	@Query(value="update m_barang set nama_barang=:nb, supplier=:sp, qty=:qt, modified_on=:modifiedon where id_barang=:id", nativeQuery = true)
	void edtBarang(int id, String nb,  String sp, int qt, String modifiedon);
}
