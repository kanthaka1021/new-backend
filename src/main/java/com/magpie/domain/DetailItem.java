package com.magpie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DetailItem {
    private Integer id;
    private String name;
    private String desc;
    private BigDecimal price;
    private String category;
    private Integer locationId;
    private String locationName;

    public DetailItem copy(BigDecimal custprice) {
        return new DetailItem(
                id,
                name,
                desc,
                custprice,
                category,
                locationId,
                locationName
        );
    }
}
