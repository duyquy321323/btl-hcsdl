package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Ward;
import com.schema.csdlbtl.csdlbtl.entity.id.WardId;

public interface WardRepository extends JpaRepository<Ward, WardId>{
    
}