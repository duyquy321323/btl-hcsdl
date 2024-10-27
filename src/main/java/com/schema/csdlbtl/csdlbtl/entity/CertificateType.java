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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Builder
@Table(name="certificate_type")
public class CertificateType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="certificate_type_id")
    private Long id;

    @Column(name="certificate_type_name")
    private String ctName;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="certificateType", orphanRemoval=true)
    private List<Certificate> certificates = new ArrayList<>();
}