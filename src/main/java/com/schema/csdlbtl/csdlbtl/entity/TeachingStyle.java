package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Builder
@Table(name="teaching_style")
public class TeachingStyle {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="teaching_style_id")
    private Long tsId;

    @Column(name="teaching_style_name")
    private String tsName;

    @ManyToMany(mappedBy="teachingStyles")
    private List<Tutor> tutors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="want_teaching_style",
        joinColumns = @JoinColumn(name="tea_style_id", nullable=false),
        inverseJoinColumns= @JoinColumn(name="consultation_id")
    )
    private List<ConsultationReq> consultationReqs = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="teachingStyle", orphanRemoval = true)
    private List<TutorApplication> tutorApplications = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="teachingStyle", orphanRemoval = true)
    private List<Classess> classes = new ArrayList<>();
}