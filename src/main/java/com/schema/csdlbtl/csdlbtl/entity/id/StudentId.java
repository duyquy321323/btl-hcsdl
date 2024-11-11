package com.schema.csdlbtl.csdlbtl.entity.id;

import com.schema.csdlbtl.csdlbtl.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentId implements Serializable {
    @OneToOne
    @JoinColumn(name = "stu_id")
    private User user;
}