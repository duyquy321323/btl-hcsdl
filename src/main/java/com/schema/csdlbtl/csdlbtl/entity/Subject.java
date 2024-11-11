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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subject")
public class Subject {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="subject_id")
    private Long subjectId;

    @Column(name="subject_name")
    private String subjectName;

    @ManyToMany(mappedBy="subjects")
    private List<Tutor> tutors = new ArrayList<>();

    @ManyToMany(mappedBy = "subjects")
    private List<ConsultationReq> consultationReqs = new ArrayList<>();

    @ManyToMany(mappedBy = "subjects")
    private List<TutorApplication> tutorApplications = new ArrayList<>();

    @ManyToMany(mappedBy="subjects")
    private List<Classess> classes = new ArrayList<>(); 
}