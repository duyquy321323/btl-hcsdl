package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.TutorApplication;

public interface TutorApplicationRepository extends JpaRepository<TutorApplication, Long> {
    
}