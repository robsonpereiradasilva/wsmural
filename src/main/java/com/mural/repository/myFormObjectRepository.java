package com.mural.repository;
 


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
import com.mural.model.myFormObject;

@Repository
public interface myFormObjectRepository extends JpaRepository<myFormObject, Long>{ 
	

}
