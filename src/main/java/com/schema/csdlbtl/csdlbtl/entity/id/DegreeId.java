package com.schema.csdlbtl.csdlbtl.entity.id;

import com.schema.csdlbtl.csdlbtl.entity.Tutor;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class DegreeId implements Serializable {
    @Column(name="degr_id")
    private Long degrId;

    @ManyToOne
    @JoinColumn(name="tutor_id")
    private Tutor tutor;
}