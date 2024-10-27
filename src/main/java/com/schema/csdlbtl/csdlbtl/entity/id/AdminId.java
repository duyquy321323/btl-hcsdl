package com.schema.csdlbtl.csdlbtl.entity.id;

import java.io.Serializable;

import com.schema.csdlbtl.csdlbtl.entity.Staff;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AdminId implements Serializable {
    private Staff staff;
}