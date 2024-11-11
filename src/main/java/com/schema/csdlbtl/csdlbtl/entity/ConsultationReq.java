package com.schema.csdlbtl.csdlbtl.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="consultation_req")
public class ConsultationReq {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cq_id")
    private Long id;

    private String requirement;

    @Column(name="cq_status")
    private String cqStatus;

    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;

    @ManyToMany
    @JoinTable(
            name="cr_want_type",
            inverseJoinColumns = @JoinColumn(name="class_type_id", nullable=false),
            joinColumns = @JoinColumn(name="consultation_id")
    )
    private List<ClassType> classTypes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="cr_want_subject",
            inverseJoinColumns = @JoinColumn(name="subject_id", nullable=false),
            joinColumns= @JoinColumn(name="consultation_id")
    )
    private List<Subject> subjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="want_teaching_style",
            inverseJoinColumns = @JoinColumn(name="tea_style_id", nullable=false),
            joinColumns= @JoinColumn(name="consultation_id")
    )
    private List<TeachingStyle> teachingStyles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="addr_id", nullable=false)
    private Address address;
}