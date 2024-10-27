package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
// @IdClass(AdminId.class)
@Table(name="administrator")
// @PrimaryKeyJoinColumn(name = "admin_id", referencedColumnName="staff_id")
@AttributeOverride(name = "id", column = @Column(name = "admin_id"))
public class Admin extends Staff {
//
//    @Id
//    @Column(name="admin_id")
//    private Long id;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, orphanRemoval=true, mappedBy="admin")
    private List<Bill> bills = new ArrayList<>();
    
    public static Admin fromStaff(Staff staff){
        Admin admin = new Admin();
        admin.setEmail(staff.getEmail());
        admin.setFullname(staff.getFullname());
        admin.setSex(staff.getSex());
        admin.setPassword(staff.getPassword());
        admin.setPhoneNumber(staff.getPhoneNumber());
        admin.setNationalId(staff.getNationalId());
        admin.setPlaceOfOrigin(staff.getPlaceOfOrigin());
        admin.setDateOfBirth(staff.getDateOfBirth());
        admin.setProfilePhoto(staff.getProfilePhoto());
        return admin;
    }
}