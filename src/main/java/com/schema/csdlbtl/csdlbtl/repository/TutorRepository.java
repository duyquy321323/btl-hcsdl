package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Tutor;
import com.schema.csdlbtl.csdlbtl.entity.id.TutorId;

public interface TutorRepository extends JpaRepository<Tutor, TutorId> {
    
}