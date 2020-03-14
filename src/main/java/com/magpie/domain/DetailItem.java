package com.magpie.domain;

import lombok.Data;

@Data
public class DetailItem {
    private Integer id;
    private String name;
    private String desc;
    private Integer price;
    private String category;
}
