package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="user")
@Entity
@Builder
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable=false, unique=true, name="phone_number")
    private String phoneNumber;

    @Column(nullable=false)
    private String password;

    @Column(name="fullname")
    private String fullname;

    @Column(name="user_sex")
    private String sex;

    @OneToMany(mappedBy="user", cascade={CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval=true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "id.user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<UserContact> userContact;
}