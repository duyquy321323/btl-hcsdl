package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name="tutor_application")
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToMany
    @JoinTable(
            name="ta_want_type",
            inverseJoinColumns = @JoinColumn(name="class_type_id", nullable=false),
            joinColumns = @JoinColumn(name="tutor_apply_id")
    )
    private List<ClassType> classTypes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="ta_want_subject",
            inverseJoinColumns = @JoinColumn(name="subject_id", nullable=false),
            joinColumns = @JoinColumn(name="tutor_apply_id")
    )
    private List<Subject> subjects = new ArrayList<>();
}