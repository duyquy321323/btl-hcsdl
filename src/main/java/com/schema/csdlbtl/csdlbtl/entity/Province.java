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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table
@Builder
public class Province {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="province_id")
    private Long id;

    @Column(name = "province_name")
    private String provinceName;

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="province", orphanRemoval=true)
    private List<District> districts = new ArrayList<>();
}