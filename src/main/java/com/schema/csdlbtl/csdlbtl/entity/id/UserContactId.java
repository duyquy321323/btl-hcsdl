package com.schema.csdlbtl.csdlbtl.entity.id;

import com.schema.csdlbtl.csdlbtl.entity.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserContactId implements Serializable {
    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "social_media_link")
    private String socialMediaLink;
}
