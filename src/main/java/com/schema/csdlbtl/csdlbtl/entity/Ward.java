package com.schema.csdlbtl.csdlbtl.entity;

import java.util.*;

import javax.persistence.*;

import com.schema.csdlbtl.csdlbtl.entity.id.WardId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ward {

    @EmbeddedId
    private WardId id;

    @Column(name = "ward_name")
    private String wardName;

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="ward", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @PrePersist
    private void prePersist() {
        if(id.getWardId() == null){
            id.setWardId(generatedWardId());
        }
    }

    private Long generatedWardId() {
        return new Random().nextLong(1, 1000000000);
    }
}