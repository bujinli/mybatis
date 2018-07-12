package com.grc.demo.mybatis.controllers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grc.demo.mybatis.domain.Student;
import com.grc.demo.mybatis.mapper.StudentMapper;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@GetMapping("/all")
	public List<Student> getStudents() {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			return mapper.getStudents();
		} finally {
			session.close();
		}
	}

	@GetMapping("/{id}")
	public Student getStudents(@PathVariable(name = "id") Integer id) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			return mapper.getStudent(id);
		} finally {
			session.close();
		}
	}

}
