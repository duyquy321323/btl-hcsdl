package com.schema.csdlbtl.csdlbtl.entity.id;

import com.schema.csdlbtl.csdlbtl.entity.Province;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DistrictId implements Serializable {
    @Column(name = "district_city_id")
    private Long districtId;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
}