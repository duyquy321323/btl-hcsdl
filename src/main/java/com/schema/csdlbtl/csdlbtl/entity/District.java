package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.schema.csdlbtl.csdlbtl.entity.id.DistrictId;

import lombok.Builder;

@Entity
@Builder
@Table(name = "district_city")
@IdClass(DistrictId.class)
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_city_id")
    private Long id;

    @Column(name = "dis_city_name")
    private String districtName;

    @Id
    @Column(name = "province_id")
    private Long provinceId;

    @ManyToOne
    @MapsId("province_id")
    @JoinColumn(referencedColumnName = "province_id")
    private Province province;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "district", orphanRemoval = true)
    private List<Ward> wards = new ArrayList<>();

    @ManyToMany(mappedBy = "districts")
    private List<Tutor> tutors = new ArrayList<>();
}