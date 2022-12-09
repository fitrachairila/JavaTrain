package com.app.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.model.barangmodel;

public interface barangrepo extends JpaRepository<barangmodel, Integer> {

	@Query(value = "select mb.id, mb.nama_barang, ms.nama_supplier, mb.qty " + "from Tbarang mb join Tsupplier ms "
			+ "on mb.id_supplier = ms.id", nativeQuery = true)
	List<Map<String, Object>> baranglist();
	
	@Modifying
	@Query(value = "insert into tbarang (id_supplier,nama_barang,qty) values(?1,?2,?3)",nativeQuery = true)
	void barangadd(int idsup, String nmb, int qt);
	
	@Modifying
	@Query(value = "update tbarang set id_supplier=:idsup,nama_barang=:nmb,qty=:qty where id=:idb",nativeQuery = true)
	void barangedit(int idsup, String nmb, int qty);
	
	@Modifying
	@Query(value ="delete from tbarang where id=:id", nativeQuery = true)
	void barangdelete(int id);
	
	@Query(value="select * from tbarang where id=:id", nativeQuery = true)
	List<barangmodel>CheckIdBarang(int id);
	
	@Query(value="select * from tsupplier where id=:id", nativeQuery = true)
	List<barangmodel>CheckIdSupplier(int id);
}
