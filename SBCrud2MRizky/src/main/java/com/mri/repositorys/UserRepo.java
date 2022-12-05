package com.mri.repositorys;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mri.models.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer> {
	
	/*-=List Edit Barang=-*/
	@Query(value="select * from m_users where users=:users and password=:password", nativeQuery = true)
	List<UserModel>logon(String users, String password);
}
