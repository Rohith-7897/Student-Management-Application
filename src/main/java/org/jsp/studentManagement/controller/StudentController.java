package org.jsp.studentManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsp.studentManagement.dto.Student;
import org.jsp.studentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/Student")
	public Student registerStudent(@RequestBody Student student) {
		System.out.println("Student has been registered");
		Student st = studentService.saveStudent(student);
		return st;
	}
	
	@GetMapping("/Students")
	public List<Student> getAllStudents(){
		List<Student> list = studentService.getAllStudents();
		return list;
	}
	
	@PutMapping("/Student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
	
	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id) {
		Student st = studentService.getStudentById(id);
		return ResponseEntity.ok(st);
	}
	
	@DeleteMapping("/Student/{id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable int id) {
		
		studentService.deleteStudentById(id);
		return ResponseEntity.noContent().build();
	}
	
}
