package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="address")
public class Address {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "addr_id")
    private Long id;

    @Column(name="street_name")
    private String streetName;

    @Column(name = "house_number")
    private Integer houseNumber;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="address", orphanRemoval=true)
    private List<Classess> classes = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "address", orphanRemoval=true)
    private List<ConsultationReq> consultationReqs = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "address", orphanRemoval=true)
    private List<TutorApplication> tutorApplications = new ArrayList<>();

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ward_id", referencedColumnName = "ward_id"),
        @JoinColumn(name = "district_city_id", referencedColumnName = "district_city_id"),
        @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    })
    private Ward ward;
}