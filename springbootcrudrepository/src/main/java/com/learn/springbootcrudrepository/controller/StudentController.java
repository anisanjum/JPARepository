package com.learn.springbootcrudrepository.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springbootcrudrepository.entity.Student;
import com.learn.springbootcrudrepository.exception.DuplicateEntryException;
import com.learn.springbootcrudrepository.exception.StudentNotFoundException;
import com.learn.springbootcrudrepository.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	/*
	 * @PostMapping("/add") public Student addStudent(@Valid @RequestBody Student
	 * student) { return studentService.addStudent(student); }
	 */


	@PostMapping("/add") public Student addStudent(@Valid @RequestBody Student student) throws DuplicateEntryException {
		if(getStudentByEmail(student.getEmail())!=null) { 
			//getStudentByPhoneNo(student.getPhoneNo())!=null) 

			throw new DuplicateEntryException("Duplicate entry as email id must be unique"); 
		}
		else 
			return studentService.addStudent(student); 
	}


	/*
	 * @PostMapping("/add") public Student addStudent(@Valid @RequestBody Student
	 * student) { return studentService.addStudent(student); }
	 */

	@GetMapping("/list")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PutMapping("update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/delete/{studentId}")
	public void deleteStudent(@PathVariable Long studentId) {
		studentService.deleteStudent(studentId);
	}

	//Paging and Sorting using JPA	

	@GetMapping("/list-students-by-pagination") 
	public ResponseEntity<Map<String,Object>> getAllStudentsByPagination(
			@RequestParam(defaultValue = "0") int pageNo, 
			@RequestParam(defaultValue = "2") int pageSize) { 
		try { 
			List<Student> list= new ArrayList<Student>();
			Pageable pageable=PageRequest.of(pageNo, pageSize);
			Page<Student> page;
			page=studentService.getStudentListByPagination(pageable);
			list = page.getContent();

			Map<String,Object> map=new HashMap<>();
			map.put("students", list);
			map.put("currentPage", page.getNumber());
			map.put("totalItems", page.getTotalElements());
			map.put("totalPages", page.getTotalPages());

			return new ResponseEntity<>(map, HttpStatus.OK); 
		} 
		catch(Exception e) { 
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }



	/*
	 * @GetMapping("/listOfStudents-by-pagination") public Page<Student>
	 * getStudentListByPagination(@RequestParam(defaultValue = "0") int
	 * pageNo, @RequestParam(defaultValue = "2") int pageSize) { Pageable pageable=
	 * PageRequest.of(pageNo, pageSize); return
	 * studentService.getStudentListByPagination(pageable); }
	 */


	//Implementing JPARepository

	@GetMapping("/getByLastName/{studentLastName}")
	public List<Student> getAllStudentByLastName(@PathVariable String studentLastName) {
		return (List<Student>) studentService.getStudentByLastName(studentLastName);
	}

	@GetMapping("/getByEmail/{email}")
	public Student getStudentByEmail(@PathVariable String email) {
		return studentService.getStudentbyEmail(email);
	}

	@GetMapping("/getByFirstName/{studentFirstName}")
	public List<Student> getAllStudentByFirstName(@PathVariable String studentFirstName) {
		return (List<Student>) studentService.getStudentByFirstName(studentFirstName);
	}

	@GetMapping("/list-by-country-sort")
	public List<Student> getAllStudentByCountrySort() {
		return studentService.getStudentSortByCountry();
	}

	@GetMapping("/list-by-city-sort")
	public List<Student> getAllStudentByCitySort() {
		return studentService.getStudentSortByCity(); 
	}

	@GetMapping("/getById/{studentId}")
	public Student getStudentById(@PathVariable Long studentId) throws StudentNotFoundException , Exception{
		Optional<Student> student = studentService.getStudentById(studentId);
		if(student.isPresent()) {
			return student.get();
		}
		else {
			//throw new StudentNotFoundException("Student Id invalid");
			throw new Exception("Invalid Student Id");
		}
	}
	
	
	  @GetMapping("/getByphoneNo/{phoneNo}") public Student
	  getStudentByPhoneNo(@PathVariable String phoneNo) { return
	  studentService.getStudentByPhoneNumber(phoneNo); }
	 

	
	/*
	 * @GetMapping("/getByphoneNo/{phoneNo}") public Student
	 * getStudentByPhoneNo(@PathVariable String phoneNo) throws Exception{ Student
	 * student=getStudentByPhoneNo(phoneNo); if(phoneNo==student.getPhoneNo()) {
	 * return studentService.getStudentByPhoneNumber(phoneNo); } else throw new
	 * Exception("Invalid Phone");
	 * 
	 * }
	 */

	@GetMapping("/getByState-sort-descending")
	public List<Student> getAllStudentByStateSortDesc() {
		return studentService.getStudentByStateSortDesc();
	}

}
