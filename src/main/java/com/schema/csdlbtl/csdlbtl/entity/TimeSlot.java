package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.Date;
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
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="slot_id")
    private Long id;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="id.timeSlot", orphanRemoval=true)
    private List<IsHeldOn> isHeldOns = new ArrayList<>(); 
}