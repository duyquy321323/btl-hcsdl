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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Builder
@Table(name="tutor_application")
public class TutorApplication {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ta_id")
    private Long id;

    private String requirement;

    @Column(name="ta_status")
    private String taStatus;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="tutor_id")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name="addr_id", nullable=false)
    private Address address;

    @ManyToOne
    @JoinColumn(name="teaching_style_id", nullable=false)
    private TeachingStyle teachingStyle;

    @ManyToMany(mappedBy="tutorApplications")
    private List<ClassType> classTypes = new ArrayList<>();

    @ManyToMany(mappedBy="tutorApplications")
    private List<Subject> subjects = new ArrayList<>();
}