package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.TeachingApplication;

public interface TeachingApplicationRepository extends JpaRepository<TeachingApplication, Long> {
    
}