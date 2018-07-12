package com.grc.demo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.grc.demo.mybatis.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> getStudents();

	Student getStudent(Integer i);
}
