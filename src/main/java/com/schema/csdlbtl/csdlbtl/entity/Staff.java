package com.schema.csdlbtl.csdlbtl.entity;

import java.util.Date;

import javax.persistence.*;

import com.schema.csdlbtl.csdlbtl.entity.id.StaffId;
import lombok.*;

@Entity
// @Builder
@Table(name = "staff")
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
// @IdClass(StaffId.class)
// @PrimaryKeyJoinColumn(name = "staff_id", referencedColumnName="user_id")
//@AttributeOverride(name = "id", column = @Column(name = "staff_id"))
public class Staff {

    @EmbeddedId
    private StaffId id;

    @Column(name = "national_id")
    private String nationalId;

    @Column(name = "place_of_origin")
    private String placeOfOrigin;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "profile_photo", length = Integer.MAX_VALUE, columnDefinition = "LONGBLOB")
    @Lob
    private byte[] profilePhoto;

     @OneToOne(mappedBy = "id.staff", cascade = { CascadeType.MERGE,
     CascadeType.PERSIST }, orphanRemoval = true)
     private Tutor tutor;

     @OneToOne(mappedBy = "id.staff", cascade = { CascadeType.MERGE,
     CascadeType.PERSIST }, orphanRemoval = true) // tham chiếu đến thực thực thể admin -> thuộc tính id (nhúng) -> thuộc tính staff
     private Admin admin;
}