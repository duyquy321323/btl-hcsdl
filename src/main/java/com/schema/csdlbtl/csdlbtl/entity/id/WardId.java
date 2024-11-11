package com.schema.csdlbtl.csdlbtl.entity.id;

import com.schema.csdlbtl.csdlbtl.entity.District;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WardId implements Serializable {
    @Column(name="ward_id")
    private Long wardId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="province_id", referencedColumnName="province_id", updatable=false, insertable = false),
            @JoinColumn(name="district_city_id", referencedColumnName = "district_city_id", updatable = false, insertable = false)
    })
    private District district;
}