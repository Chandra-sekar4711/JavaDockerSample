package com.Basic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Basic.Model.MTMcourses;

@Repository
public interface MTMcoursesRepository extends JpaRepository<MTMcourses, Integer> {
}
