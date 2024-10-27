package com.schema.csdlbtl.csdlbtl.entity;

import javax.persistence.*;

import com.schema.csdlbtl.csdlbtl.entity.id.QualificationId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="qualifications")
//@IdClass(QualificationId.class)
@Getter
public class Qualification {
//    @Id
//    private String qualification;
//
//    @Id
//    @Column(name = "tutor_id")
//    private Long tutorId;

//    @ManyToOne
//    @JoinColumn(name="tutor_id", nullable=false, insertable=false, updatable=false)
//    private Tutor tutor;
    @EmbeddedId
    private QualificationId qualificationId;
}