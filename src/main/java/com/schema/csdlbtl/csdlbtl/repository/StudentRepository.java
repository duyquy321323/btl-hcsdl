package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Student;
import com.schema.csdlbtl.csdlbtl.entity.id.StudentId;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}