package org.jsp.studentManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.studentManagement.dao.StudentRepo;
import org.jsp.studentManagement.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo repo;
	
	@Override
	public Student saveStudent(Student student) {
		// Invoke logic to store data in database
		repo.save(student);
		return student;
	}
	
	@Override
	public List<Student> getAllStudents(){
		// Inovke logic to retrive all student records in database
		return  repo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> optional = repo.findById(id);
		return optional.get();
	}

	@Override
	public void deleteStudentById(int id) {
		repo.deleteById(id);
	}
	
	@Override
	public Student updateStudent(Student student) {
        Optional<Student> optional = repo.findById(student.getId());
        if (optional.isPresent()) {
            Student existingStudent = optional.get();
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setFatherName(student.getFatherName());
            existingStudent.setPhoneNumber(student.getPhoneNumber());
            existingStudent.setClassName(student.getClassName());
            return repo.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found with id " + student.getId());
        }
    }

}
