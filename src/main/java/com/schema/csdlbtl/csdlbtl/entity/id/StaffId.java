package com.schema.csdlbtl.csdlbtl.entity.id;

import java.io.Serializable;

import com.schema.csdlbtl.csdlbtl.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StaffId implements Serializable {
    private User user;
}