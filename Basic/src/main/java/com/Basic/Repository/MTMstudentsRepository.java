package com.Basic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Basic.Model.MTMstudents;

@Repository
public interface MTMstudentsRepository extends JpaRepository<MTMstudents, Integer> {
}
