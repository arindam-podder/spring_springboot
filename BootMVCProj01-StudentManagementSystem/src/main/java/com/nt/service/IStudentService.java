package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface IStudentService {
	
	public List<Student> getAllStudent();
	
	public Student addStudent(Student student);
	
	public Student getStudentById(Long id);
	
	public Student updateStudent(Student student); 
	
	public void deleteStudentById(Long id);
	
}
