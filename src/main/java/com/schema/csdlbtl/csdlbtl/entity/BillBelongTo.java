package com.schema.csdlbtl.csdlbtl.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.schema.csdlbtl.csdlbtl.entity.id.BillBelongToId;

import lombok.Builder;

@Entity
@Builder
@IdClass(BillBelongToId.class)
@Table(name="belong_to")
public class BillBelongTo {

    @Id
    @Column(name="bill_id")
    private Long billId;

    @OneToOne
    @JoinColumn(name="bill_id", referencedColumnName="bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name="class_id", nullable=false)
    private Classess classess;

    @ManyToOne
    @JoinColumn(name="tutor_id", nullable=false)
    private Tutor tutor;
}