package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.schema.csdlbtl.csdlbtl.entity.id.AdminId;
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
//@AttributeOverride(name = "id", column = @Column(name = "admin_id"))
public class Admin {
//
    @EmbeddedId // Nhúng thực thể thành khóa chính
    private AdminId id;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, orphanRemoval=true, mappedBy="admin")
    private List<Bill> bills = new ArrayList<>();
}