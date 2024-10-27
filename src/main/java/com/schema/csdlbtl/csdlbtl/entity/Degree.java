package com.schema.csdlbtl.csdlbtl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.schema.csdlbtl.csdlbtl.entity.id.DegreeId;

import lombok.Builder;

@IdClass(DegreeId.class)
@Entity
@Builder
@Table(name="degree")
public class Degree {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="degr_id")
    private Long degrId;

    @Id
    @Column(name="tutor_id")
    private Long tutorId;

    @ManyToOne
    @JoinColumn(name="tutor_id", updatable=false, insertable=false)
    private Tutor tutor;

    @Column(name="degr_type")
    private String degrType;

    @Column(name="degr_year")
    private Integer degrYear;

    @Column(name="degr_major_name")
    private String degrMajorName;

    @ManyToOne
    @JoinColumn(name="granted_intitution_id", nullable=false)
    private EducationalInstitution educationalInstitution;
}