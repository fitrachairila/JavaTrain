package com.mri.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mri.models.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
