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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="degree_institution")
public class EducationalInstitution {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="edi_code")
    private Long ediCode;

    @Column(name="edi_name")
    private String ediName;

    @ManyToMany(mappedBy="educationalInstitutions")
    private List<Tutor> tutors = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="educationalInstitution", orphanRemoval=true)
    private List<Degree> degrees = new ArrayList<>();
}