package com.example.demo.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Office;

import jakarta.transaction.Transactional;

@Repository
public interface OfficeRepositry extends JpaRepository<Office, Integer> {

	
	 @Modifying
	    @Transactional
	    @Query("update Office o set o.phone = :phone where o.officecode = :id")
	    int updatePhone(@Param("id") int id,
	                    @Param("phone") String phone);
	 
	 
//	 @Modifying
//	    @Transactional 
//	 long countByCountry(String country);
}
