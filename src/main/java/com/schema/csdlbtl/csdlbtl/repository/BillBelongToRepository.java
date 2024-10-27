package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.BillBelongTo;
import com.schema.csdlbtl.csdlbtl.entity.id.BillBelongToId;

public interface BillBelongToRepository extends JpaRepository<BillBelongTo, BillBelongToId> {

}