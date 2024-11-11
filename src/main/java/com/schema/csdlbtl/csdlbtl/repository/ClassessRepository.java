package com.schema.csdlbtl.csdlbtl.repository;

import com.schema.csdlbtl.csdlbtl.entity.Student;
import com.schema.csdlbtl.csdlbtl.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Classess;

import java.util.List;

public interface ClassessRepository extends JpaRepository<Classess, Long> {
    public List<Classess> findByStudent(Student student);
    public List<Classess> findByTutor(Tutor tutor);
}