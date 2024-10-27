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

import com.schema.csdlbtl.csdlbtl.entity.id.CertificateId;

import lombok.Builder;

@Entity
@Builder
@Table(name="certificate")
@IdClass(CertificateId.class)
public class Certificate {
    
    @Id
    @Column(name="cert_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long cerId;

    @Id
    @Column(name="tutor_id")
    private Long tutorId;

    @MapsId("tutor_id")
    @ManyToOne
    @JoinColumn(name="tutor_id")
    private Tutor tutor;

    @Column(name="cert_year")
    private Integer cerYear;

    @ManyToOne
    @JoinColumn(name="certificate_type_id", nullable=false)
    private CertificateType certificateType;
}