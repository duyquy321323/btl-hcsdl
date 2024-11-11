package com.schema.csdlbtl.csdlbtl.entity.id;

import java.io.Serializable;

import com.schema.csdlbtl.csdlbtl.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorId implements Serializable {
    @OneToOne
    @JoinColumn(name="tutor_id")
    private Staff staff;
}