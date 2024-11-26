package org.jsp.studentManagement.service;

import java.util.List;

import org.jsp.studentManagement.dto.Student;

public interface StudentService {
		
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(int id);
	
	public void deleteStudentById(int id);

	public Student updateStudent(Student student);
	
}
