package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.IsHeldOn;
import com.schema.csdlbtl.csdlbtl.entity.id.IsHeldOnId;

public interface IsHeldOnRepository extends JpaRepository<IsHeldOn, IsHeldOnId> {
    
}