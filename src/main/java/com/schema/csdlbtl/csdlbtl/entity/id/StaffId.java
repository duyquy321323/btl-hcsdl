package com.schema.csdlbtl.csdlbtl.entity.id;

import java.io.Serializable;

import com.schema.csdlbtl.csdlbtl.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class StaffId implements Serializable {
    @OneToOne
    @JoinColumn(name = "staff_id")
    private User user;
}