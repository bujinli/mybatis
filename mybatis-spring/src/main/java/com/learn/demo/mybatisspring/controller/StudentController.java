package com.learn.demo.mybatisspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.demo.mybatisspring.domain.Student;
import com.learn.demo.mybatisspring.mapper.StudentMapper;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	StudentMapper mapper;

	@GetMapping("/all")
	@Transactional
	public List<Student> getStudents() {
		// SqlSession session = sqlSessionFactory.openSession();
		//
		// try {
		// StudentMapper mapper = session.getMapper(StudentMapper.class);
		return mapper.getStudents();
		// } finally {
		// session.close();
		// }
	}

	@GetMapping("/{id}")
	// @Transactional
	public Student getStudents(@PathVariable(name = "id") Integer id) {
		// SqlSession session = sqlSessionFactory.openSession();
		//
		// try {
		// StudentMapper mapper = session.getMapper(StudentMapper.class);
		return mapper.getStudent(id);
		// } finally {
		// session.close();
		// }
	}

}
