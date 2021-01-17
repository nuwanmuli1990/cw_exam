package com.iit.exam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.exam.entities.Exam;
import com.iit.exam.models.ExamResponse;
import com.iit.exam.repositories.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepository;


	@Autowired
	private HttpServletRequest request;

	@Override
	public List<ExamResponse> getExams() {

		List<Exam> exams = examRepository.findAll();

		List<ExamResponse> response = new ArrayList<>();
		for (Exam exam : exams) {

			ExamResponse examResponse = new ExamResponse(exam.getId(), exam.getName(),
					exam.getPassMark());
			response.add(examResponse);
		}

		return response;
	}

	@Override
	public ExamResponse getExam(Long id) {

		ExamResponse response = new ExamResponse();
		Optional<Exam> optionalExam = examRepository.findById(id);
		if (optionalExam.isPresent()) {

			response.setId(optionalExam.get().getId());
			response.setName(optionalExam.get().getName());
			response.setPassMark(optionalExam.get().getPassMark());

		}
		return response;
	}
}
