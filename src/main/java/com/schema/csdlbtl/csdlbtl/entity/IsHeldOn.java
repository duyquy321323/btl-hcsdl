package com.schema.csdlbtl.csdlbtl.entity;

import javax.persistence.*;

import com.schema.csdlbtl.csdlbtl.entity.id.IsHeldOnId;

import lombok.*;

@Entity
@Table
@Builder
//@IdClass(IsHeldOnId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IsHeldOn {

    @EmbeddedId
    private IsHeldOnId id;
}