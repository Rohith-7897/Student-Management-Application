package org.jsp.studentManagement.dao;

import org.jsp.studentManagement.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
}
