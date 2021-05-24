package com.learn.springbootcrudrepository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learn.springbootcrudrepository.entity.Student;
import com.learn.springbootcrudrepository.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return (List<Student>) studentRepository.findAll();
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Long studentId) {
		studentRepository.deleteById(studentId);
	}
	
	/*
	 * public List<Student> getStudentListByPagination(Integer pageNo, Integer
	 * pageSize) { Pageable paging= PageRequest.of(pageNo, pageSize); Page<Student>
	 * pagedResult=studentRepository.findAll(paging); return pagedResult; }
	 */	
	
	public Page<Student> getStudentListByPagination(Pageable paging) {
		return studentRepository.findAll(paging);		
	}
	
	//Implementing JPARepository

	public List<Student> getStudentByLastName(String studentLastName) {
		// TODO Auto-generated method stub
		return (List<Student>)studentRepository.findByStudentLastName(studentLastName);
	}
	
	public List<Student> getStudentByFirstName(String studentFirstName) {
		return studentRepository.findByStudentFirstName(studentFirstName);
	}
	
	public Student getStudentbyEmail(String email) {
		return studentRepository.findByEmail(email);
	}
	
	public List<Student> getStudentSortByCountry() {
	return studentRepository.findAll(Sort.by("country"));		
	}
	
	public List<Student> getStudentSortByCity() {
		return studentRepository.findAll(Sort.by("city"));
	}
	
	public Optional<Student> getStudentById(Long id){
		return studentRepository.findById(id);
	}
	
	public Student getStudentByPhoneNumber(String phoneno) {
		return studentRepository.findByPhoneNo(phoneno);
	}
	
	public List<Student> getStudentByStateSortDesc() {
		return studentRepository.findAll(Sort.by("state").descending());
	}

}
 