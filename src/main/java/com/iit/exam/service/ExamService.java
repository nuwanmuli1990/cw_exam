package com.iit.exam.service;

import java.util.List;

import com.iit.exam.models.ExamResponse;

public interface ExamService {

	List<ExamResponse> getExams();
	
	ExamResponse getExam(Long id);
	
}
