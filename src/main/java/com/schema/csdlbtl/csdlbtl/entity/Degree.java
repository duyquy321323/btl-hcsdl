package com.schema.csdlbtl.csdlbtl.entity;

import javax.persistence.*;

import com.schema.csdlbtl.csdlbtl.entity.id.DegreeId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Random;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="degree")
public class Degree {
    @EmbeddedId
    private DegreeId id;

    @Column(name="degr_type")
    private String degrType;

    @Column(name="degr_year")
    private Integer degrYear;

    @Column(name="degr_major_name")
    private String degrMajorName;

    @ManyToOne
    @JoinColumn(name="granted_institution_id", nullable=false)
    private EducationalInstitution educationalInstitution;

    @PrePersist
    private void prePersist() {
        if(id.getDegrId() == null) {
            id.setDegrId(generatedDegrId());
        }
    }

    private Long generatedDegrId(){
        return new Random().nextLong(1, 1000000000);
    }
}