package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.EducationalInstitution;

public interface EducationalInstitutionRepository extends JpaRepository<EducationalInstitution, Long> {
    
}