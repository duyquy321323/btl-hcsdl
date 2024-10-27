package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    
}