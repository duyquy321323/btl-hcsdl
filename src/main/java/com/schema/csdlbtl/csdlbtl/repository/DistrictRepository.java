package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.District;
import com.schema.csdlbtl.csdlbtl.entity.id.DistrictId;

public interface DistrictRepository extends JpaRepository<District, DistrictId> {
    
}