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

import lombok.Builder;

@Entity
@Builder
@Table(name="tutor_review")
public class TutorReview {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tutor_review_id")
    private Long id;

    private String comment;
    private Integer rate;

    @Column(name="time_stamp")
    private Date time_stamp;

    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="class_id", nullable = false)
    private Classess classess;
}