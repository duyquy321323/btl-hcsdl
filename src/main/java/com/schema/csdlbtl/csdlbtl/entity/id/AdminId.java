package com.schema.csdlbtl.csdlbtl.entity.id;

import java.io.Serializable;

import com.schema.csdlbtl.csdlbtl.entity.Staff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable // Tạo thực thể nhúng
@Builder
public class AdminId implements Serializable {
    @OneToOne
    @JoinColumn(name="admin_id")
    private Staff staff;
}