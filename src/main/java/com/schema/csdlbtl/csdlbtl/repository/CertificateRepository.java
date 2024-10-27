package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Certificate;
import com.schema.csdlbtl.csdlbtl.entity.id.CertificateId;

public interface CertificateRepository extends JpaRepository<Certificate, CertificateId> {
    
}