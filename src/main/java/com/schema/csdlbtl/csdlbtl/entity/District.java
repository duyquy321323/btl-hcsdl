package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.*;

import com.schema.csdlbtl.csdlbtl.entity.id.DistrictId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "district_city")
@AllArgsConstructor
@NoArgsConstructor
public class District {
    @EmbeddedId
    private DistrictId id;

    @Column(name = "dis_city_name")
    private String districtName;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "id.district", orphanRemoval = true)
    private List<Ward> wards = new ArrayList<>();

    @ManyToMany(mappedBy = "districts")
    private List<Tutor> tutors = new ArrayList<>();

    @PrePersist
    private void prePersist() {
        if(id.getDistrictId() == null){
            id.setDistrictId(generatedDistrictId());
        }
    }

    private Long generatedDistrictId(){
        return new Random().nextLong(1, 1000000000);
    }
}