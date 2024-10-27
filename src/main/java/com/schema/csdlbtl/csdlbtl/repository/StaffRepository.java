package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Staff;
import com.schema.csdlbtl.csdlbtl.entity.id.StaffId;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    
}