package com.nt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.IStudentRepository;
import com.nt.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	private IStudentRepository repository;

	public StudentServiceImpl(IStudentRepository repo) {	//autometically injected 
		this.repository = repo;
	}
	
	@Override
	public List<Student> getAllStudent() {
		return repository.findAll();
	}
	
	@Override
	public Student addStudent(Student student) {
		Student savedStudent = repository.save(student);
		return savedStudent;
	}
	
	@Override
	public Student getStudentById(Long id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Student updateStudent(Student student) {
		Student updatedStudent = repository.save(student);
		return updatedStudent;
	}
	
	@Override
	public void deleteStudentById(Long id) {
		repository.deleteById(id);
	}
}








