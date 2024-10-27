package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Qualification;
import com.schema.csdlbtl.csdlbtl.entity.id.QualificationId;

public interface QualificationRepository extends JpaRepository<Qualification, QualificationId> {
    
}