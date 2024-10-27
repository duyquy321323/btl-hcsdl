package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.schema.csdlbtl.csdlbtl.entity.id.WardId;

import lombok.Builder;

@Entity
@Table
@Builder
@IdClass(WardId.class)
public class Ward {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ward_id")
    private Long id;

    @Column(name = "ward_name", unique=true)
    private String wardName;

    @Id
    @Column(name = "district_city_id")
    private Long districtId;

    @Id
    @Column(name = "province_id")
    private Long provinceId;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="province_id", referencedColumnName="province_id", updatable=false, insertable = false),
        @JoinColumn(name="district_city_id", referencedColumnName = "district_city_id", updatable = false, insertable = false)
    })
    private District district;

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="ward", orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();
}