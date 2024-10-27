package com.schema.csdlbtl.csdlbtl.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table
@Builder
public class Bill {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bill_id")
    private Long id;

    @Column(name="bill_money")
    private Long billMoney;

    @Lob
    @Column(name="bill_photo_url", columnDefinition="LONGBLOB")
    private byte[] billPhotoUrl;

    @Column(name="bill_type")
    private String billType;

    @Column(name="bill_status")
    private String billStatus;

    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval=true)
    @JoinColumn(name="vou_id", referencedColumnName="vou_id")
    private Voucher voucher;

    @OneToOne(mappedBy="bill", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    private BillBelongTo billBelongTo;
}