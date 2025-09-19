package com.Basic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Basic.Model.OTMitem;

@Repository
public interface OTMitemsrepository extends JpaRepository<OTMitem, Integer>{

}
