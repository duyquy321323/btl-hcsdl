package com.schema.csdlbtl.csdlbtl.entity.id;

import com.schema.csdlbtl.csdlbtl.entity.CertificateType;
import com.schema.csdlbtl.csdlbtl.entity.Tutor;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CertificateId implements Serializable {
    @ManyToOne
    @JoinColumn(name="tutor_id")
    private Tutor tutor;

    @Column(name="cert_id")
    private Long cerId;
}