package com.schema.csdlbtl.csdlbtl.entity.id;

import com.schema.csdlbtl.csdlbtl.entity.Classess;
import com.schema.csdlbtl.csdlbtl.entity.TimeSlot;
import com.schema.csdlbtl.csdlbtl.entity.WeekDay;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IsHeldOnId implements Serializable {
    @ManyToOne
    @JoinColumn(name="class_id", referencedColumnName="class_id")
    private Classess classess;

    @ManyToOne
    @JoinColumn(name="slot_id", referencedColumnName="slot_id")
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name="weekday_id", referencedColumnName="weekday_id")
    private WeekDay weekDay;
}