package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Admin;
import com.schema.csdlbtl.csdlbtl.entity.id.AdminId;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}