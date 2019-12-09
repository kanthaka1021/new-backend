package com.magpie.domain;

import lombok.Data;

@Data
public class WeatherInfo {
    private Integer degree;
    private String degreeUnit;
    private String status;
}
