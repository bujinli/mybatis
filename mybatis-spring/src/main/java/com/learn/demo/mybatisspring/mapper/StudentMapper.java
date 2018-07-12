package com.learn.demo.mybatisspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.learn.demo.mybatisspring.domain.Student;

@Mapper
public interface StudentMapper {

	List<Student> getStudents();

	Student getStudent(Integer i);
}
