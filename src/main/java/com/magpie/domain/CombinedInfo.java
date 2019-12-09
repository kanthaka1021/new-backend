package com.magpie.domain;

import lombok.Data;

@Data
public class CombinedInfo {
    private String email;
    private WeatherInfo weather;
}
