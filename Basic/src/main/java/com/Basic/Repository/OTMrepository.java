package com.Basic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Basic.Model.OTMuniversity;

@Repository
public interface OTMrepository extends JpaRepository<OTMuniversity, Integer> {

}
