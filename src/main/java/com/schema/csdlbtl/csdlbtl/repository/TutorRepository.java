package com.schema.csdlbtl.csdlbtl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schema.csdlbtl.csdlbtl.entity.Tutor;
import com.schema.csdlbtl.csdlbtl.entity.id.TutorId;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, TutorId> {
    public List<Tutor> findByInvitings(Tutor tutor);
}