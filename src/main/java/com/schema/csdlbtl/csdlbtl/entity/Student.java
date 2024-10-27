package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// @Builder
@Table(name = "student")
@NoArgsConstructor
@Setter
// @IdClass(StudentId.class)
@AllArgsConstructor
// @PrimaryKeyJoinColumn(name = "student_id", referencedColumnName="user_id")
@AttributeOverride(name = "id", column = @Column(name = "stu_id"))
public class Student extends User {

//    @Id
//    @Column(name = "stu_id")
//    private Long id;

    // @OneToOne
    // @MapsId("userId")
    // @JoinColumn(name = "stu_id", referencedColumnName = "user_id")
    // private User user;

    @Column(name = "stu_school")
    private String stuSchool;

    @Column(name = "stu_grade")
    private Integer stuGrade;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "student", orphanRemoval = true)
    private List<Classess> classes = new ArrayList<>();

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "student", orphanRemoval = true)
    private List<TutorApplication> tutorApplications = new ArrayList<>();

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "student", orphanRemoval = true)
    private List<ConsultationReq> consultationReqs = new ArrayList<>();

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "student", orphanRemoval = true)
    private List<TutorReview> tutorReviews = new ArrayList<>();
    
    public static Student fromUser(User user){
        Student student = new Student();
        student.setEmail(user.getEmail());
        student.setFullname(user.getFullname());
        student.setSex(user.getSex());
        student.setPassword(user.getPassword());
        student.setPhoneNumber(user.getPhoneNumber());
        return student;
    }
}