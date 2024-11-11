package com.schema.csdlbtl.csdlbtl.entity;

import com.schema.csdlbtl.csdlbtl.entity.id.UserContactId;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserContact {
    @EmbeddedId
    private UserContactId id;
}
