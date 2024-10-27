package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Degree;
import com.schema.csdlbtl.csdlbtl.entity.id.DegreeId;

public interface DegreeRepository extends JpaRepository<Degree, DegreeId> {
    
}