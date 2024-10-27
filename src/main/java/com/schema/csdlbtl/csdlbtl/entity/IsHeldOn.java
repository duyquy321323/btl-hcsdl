package com.schema.csdlbtl.csdlbtl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.schema.csdlbtl.csdlbtl.entity.id.IsHeldOnId;

import lombok.Builder;

@Entity
@Table
@Builder
@IdClass(IsHeldOnId.class)
public class IsHeldOn {
    @Id
    @Column(name="class_id")
    private Long classId;
    
    @Id
    @Column(name = "slot_id")
    private Long slotId;

    @Id
    @Column(name = "weekday_id")
    private Long weekId;

    @ManyToOne
    @MapsId("class_id")
    @JoinColumn(name="class_id", referencedColumnName="class_id")
    private Classess classess;

    @ManyToOne
    @MapsId("slot_id")
    @JoinColumn(name="slot_id", referencedColumnName="slot_id")
    private TimeSlot timeSlot;

    @ManyToOne
    @MapsId("weekday_id")
    @JoinColumn(name="weekday_id", referencedColumnName="weekday_id")
    private WeekDay weekDay;
}