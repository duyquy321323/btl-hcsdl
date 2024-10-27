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
@AttributeOverride(name = "id", column = @Column(name="user_id"))
//@MappedSuperclass
public class User{

    @Column(nullable=false)
    private String email;

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

    // @OneToOne(mappedBy = "user", cascade={CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval=true)
    // private Student student;

    // @OneToOne(mappedBy = "user", cascade={CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval=true)
    // private Staff staff;
}