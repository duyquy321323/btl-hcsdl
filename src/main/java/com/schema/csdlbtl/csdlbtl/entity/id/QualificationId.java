package com.schema.csdlbtl.csdlbtl.entity.id;

import java.io.Serializable;

import com.schema.csdlbtl.csdlbtl.entity.Tutor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QualificationId implements Serializable {
    @ManyToOne
    @JoinColumn(name="tutor_id", nullable=false, insertable=false, updatable=false)
    private Tutor tutor;
    private String qualification;
}