package com.schema.csdlbtl.csdlbtl.entity;

import javax.persistence.*;
import javax.sound.midi.Sequence;

import com.schema.csdlbtl.csdlbtl.entity.id.CertificateId;

//import com.schema.csdlbtl.csdlbtl.util.StaticValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

@Entity
@Builder
@Table(name="certificate")
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(CertificateId.class)
public class Certificate{

    @EmbeddedId
    private CertificateId id;

    @Column(name="cert_year")
    private Integer cerYear;

    @Column(name = "cert_grade")
    private String certGrade;

    @ManyToOne
    @JoinColumn(name="certificate_type_id", nullable=false)
    private CertificateType certificateType;

    @PrePersist
    private void prePersist(){
        if(id.getCerId() == null){
            id.setCerId(generatedCerId());
        }
    }

    private Long generatedCerId(){
        return new Random().nextLong(1, 1000000000);
    }
}