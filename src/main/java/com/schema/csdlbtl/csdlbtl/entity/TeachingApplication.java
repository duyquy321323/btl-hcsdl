package com.schema.csdlbtl.csdlbtl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="teaching_application")
public class TeachingApplication {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tea_id")
    private Long id;

    @Column(name="application_status")
    private String applicationStatus;

    @Column(name="date_of_creation")
    private Date dateOfCreation;

    @ManyToOne
    @JoinColumn(name="tutor_id", nullable=false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name="class_id", nullable=false)
    private Classess classes;
}