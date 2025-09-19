package com.Basic.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Basic.Model.OTMorder;

import jakarta.transaction.Transactional;

@Repository
public interface OTMorderrepository extends JpaRepository<OTMorder, Integer>{

	@Query("SELECT o FROM OTMorder o LEFT JOIN FETCH o.otmitems WHERE o.orderid = :id")
	Optional<OTMorder> findByIdWithItems(@Param("id") Integer id);


}
