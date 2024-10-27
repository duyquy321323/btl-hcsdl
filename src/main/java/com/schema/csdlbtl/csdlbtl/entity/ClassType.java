package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Builder
@Table(name="class_type")
public class ClassType {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_type_id")
    private Long id;

    @Column(name="class_type_name")
    private String classTypeName;

    @ManyToMany(mappedBy="classTypes")
    private List<Tutor> tutors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="cr_want_type",
        joinColumns = @JoinColumn(name="class_type_id", nullable=false),
        inverseJoinColumns = @JoinColumn(name="consultation_id")
    )
    private List<ConsultationReq> consultationReqs = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="ta_want_type",
        joinColumns = @JoinColumn(name="class_type_id", nullable=false),
        inverseJoinColumns = @JoinColumn(name="tutor_apply_id")
    )
    private List<TutorApplication> tutorApplications = new ArrayList<>();

    @ManyToMany(mappedBy="classTypes")
    private List<Classess> classes = new ArrayList<>(); 
}