package com.Basic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Basic.Model.OTOpersonModel;

@Repository
public interface OTOrepository extends JpaRepository<OTOpersonModel, Integer>{
	

}
