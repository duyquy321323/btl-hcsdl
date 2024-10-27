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
@Table(name="consultation_req")
public class ConsultationReq {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cq_id")
    private Long id;

    private String requirements;

    @Column(name="cq_status")
    private String cqStatus;

    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;

    @ManyToMany(mappedBy="consultationReqs")
    private List<ClassType> classTypes = new ArrayList<>();

    @ManyToMany(mappedBy="consultationReqs")
    private List<Subject> subjects = new ArrayList<>();

    @ManyToMany(mappedBy="consultationReqs")
    private List<TeachingStyle> teachingStyles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="addr_id", nullable=false)
    private Address address;
}