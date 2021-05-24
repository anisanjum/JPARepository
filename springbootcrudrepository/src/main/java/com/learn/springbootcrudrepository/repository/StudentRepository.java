package com.learn.springbootcrudrepository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.learn.springbootcrudrepository.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, PagingAndSortingRepository<Student, Long>, CrudRepository<Student, Long> {

	List<Student> findByStudentLastName(String studentLastName);
	
	List<Student> findByStudentFirstName(String studentFirstName);
		
	Student findByEmail(String email);
	
	Student findByPhoneNo(String phoneNo);

	}
