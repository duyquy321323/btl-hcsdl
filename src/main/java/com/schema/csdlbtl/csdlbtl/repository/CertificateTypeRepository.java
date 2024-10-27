package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.CertificateType;

public interface CertificateTypeRepository extends JpaRepository<CertificateType, Long> {
    
}