package com.schema.csdlbtl.csdlbtl.repository;

import com.schema.csdlbtl.csdlbtl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Address;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Long> {
    public List<Address> findByUser(User user);
}