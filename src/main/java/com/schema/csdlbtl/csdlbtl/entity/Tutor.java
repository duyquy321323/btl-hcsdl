package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.AttributeAccessor;

@Entity
// @Builder
@Setter
@Getter
@Table(name="tutor")
@AllArgsConstructor
@NoArgsConstructor
// @IdClass(TutorId.class)
// @PrimaryKeyJoinColumn(name = "tutor_id", referencedColumnName="staff_id")
//@AttributeOverride(name = "id", column = @Column(name = "tutor_id"))
public class Tutor extends Staff {
    
    // @OneToOne
    // // @MapsId("staffId")
    // @JoinColumn(name="tutor_id", referencedColumnName = "staff_id")
    // private Staff staff;

    private String bio;

    private Integer rate;

    @Column(name="date_joined")
    private Date dateJoined;

    @Column(name="inviting_code")
    private String invitingCode;

    @Column(name="n_of_invitations")
    private Integer nOfInvitations;

    @OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="qualificationId.tutor", orphanRemoval=true)
    private List<Qualification> qualifications = new ArrayList<>();

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="invitedCode", orphanRemoval=true)
    private List<Tutor> invitings = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="invited_code")
    private Tutor invitedCode;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="tutor", orphanRemoval = true)
    private List<Certificate> certificates = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="tutor", orphanRemoval=true)
    private List<Classess> classess = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="tutor", orphanRemoval=true)
    private List<Degree> degrees = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="tutor", orphanRemoval=true)
    private List<TeachingApplication> teachingApplications = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="can_teach_type",
        joinColumns=@JoinColumn(name="tutor_id"),
        inverseJoinColumns=@JoinColumn(name="class_type_id", nullable=false)
    )
    private List<ClassType> classTypes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="can_teach_subject",
        joinColumns=@JoinColumn(name="tutor_id"),
        inverseJoinColumns=@JoinColumn(name="subject_id", nullable=false)
    )
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="tutor", orphanRemoval = true)
    private List<Voucher> vouchers = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="tutor", orphanRemoval = true)
    private List<BillBelongTo> billBelongTos = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST}, mappedBy="tutor", orphanRemoval = true)
    private List<TutorApplication> tutorApplications = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="can_teach_at",
        joinColumns=@JoinColumn(name="tutor_id"),
        inverseJoinColumns={
            @JoinColumn(name="district_city_id", referencedColumnName="district_city_id", updatable=false, insertable=false),
            @JoinColumn(name="province_id", referencedColumnName="province_id", updatable = false, insertable = false)
        }
    )
    private List<District> districts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="can_teach_style",
        joinColumns=@JoinColumn(name="tutor_id"),
        inverseJoinColumns=@JoinColumn(name="style_id", nullable=false)
    )
    private List<TeachingStyle> teachingStyles = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name="graduated_from",
        joinColumns=@JoinColumn(name="tutor_id"),
        inverseJoinColumns=@JoinColumn(name="institution_id", nullable=false)
    )
    private List<EducationalInstitution> educationalInstitutions = new ArrayList<>();

    public static Tutor fromStaff(Staff staff){
        Tutor tutor = new Tutor();
        tutor.setEmail(staff.getEmail());
        tutor.setFullname(staff.getFullname());
        tutor.setSex(staff.getSex());
        tutor.setPassword(staff.getPassword());
        tutor.setPhoneNumber(staff.getPhoneNumber());
        tutor.setNationalId(staff.getNationalId());
        tutor.setPlaceOfOrigin(staff.getPlaceOfOrigin());
        tutor.setDateOfBirth(staff.getDateOfBirth());
        tutor.setProfilePhoto(staff.getProfilePhoto());
        return tutor;
    }
}