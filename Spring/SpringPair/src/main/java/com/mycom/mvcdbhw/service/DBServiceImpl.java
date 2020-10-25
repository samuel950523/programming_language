package com.mycom.mvcdbhw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mvcdbhw.dao.DBDao;
import com.mycom.mvcdbhw.dto.QuizDto;

@Service
public class DBServiceImpl implements DBService {

	@Autowired
	DBDao dao;
	
	@Override
	public QuizDto quizDetail(int q_index) {
		return dao.quizDetail(q_index);
	}

	@Override
	public List<QuizDto> quizList() {
		return dao.quizList();
	}

	@Override
	public int quizInsert(QuizDto dto) {
		return dao.quizInsert(dto);
	}

	@Override
	public int quizUpdate(QuizDto dto) {
		return dao.quizUpdate(dto);
	}

	@Override
	public int quizDelete(int q_index) {
		return dao.quizDelete(q_index);
	}

}
