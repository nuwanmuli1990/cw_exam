package com.iit.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iit.exam.entities.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>{

	
}
