package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.WeekDay;

public interface WeekDayRepository extends JpaRepository<WeekDay, Long> {
    
}