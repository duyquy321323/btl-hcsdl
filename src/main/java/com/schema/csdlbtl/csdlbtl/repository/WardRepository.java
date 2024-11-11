package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Ward;
import com.schema.csdlbtl.csdlbtl.entity.id.WardId;

import java.util.List;

public interface WardRepository extends JpaRepository<Ward, WardId>{
    public List<Ward> findByWardName(String name);
}