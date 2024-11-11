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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Table(name="class")
public class Classess {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_id")
    private Long id;

    private Long salary;

    private String requirement;

    @ManyToOne
    @JoinColumn(name="addr_id", nullable=false)
    private Address address;

    @Column(name="commistion_fee")
    private Long commistionFee;

    @Column(name="class_deposit")
    private Long classDeposit;

    @Column(name="class_status")
    private String classStatus;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="tutor_id")
    private Tutor tutor;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="classes", orphanRemoval = true)
    private List<TeachingApplication> teachingApplications = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="has_class_type",
        joinColumns=@JoinColumn(name="class_id"),
        inverseJoinColumns=@JoinColumn(name="class_type_id", nullable = false)
    )
    private List<ClassType> classTypes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="has_subject",
        joinColumns=@JoinColumn(name="class_id"),
        inverseJoinColumns=@JoinColumn(name="subject_id", nullable = false)
    )
    private List<Subject> subjects = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="teaching_style_id", nullable = false)
    private TeachingStyle teachingStyle;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy = "classess", orphanRemoval=true)
    private List<TutorReview> reviews = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy = "classess", orphanRemoval=true)
    private List<BillBelongTo> billBelongTos = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="id.classess", orphanRemoval=true)
    private List<IsHeldOn> isHeldOns = new ArrayList<>();
}