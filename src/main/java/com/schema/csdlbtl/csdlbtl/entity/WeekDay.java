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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeekDay {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="weekday_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy="id.weekDay", cascade={CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<IsHeldOn> isHeldOns = new ArrayList<>();
}