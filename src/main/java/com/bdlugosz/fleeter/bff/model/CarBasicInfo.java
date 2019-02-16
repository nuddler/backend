package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBasicInfo {

    public String id;

    private boolean taken;

    private String takenBy;

    private String name;

    private String iconUrl;

    private String iconTitle;

    private Long totalMileage;

    private String colour;

    private String brand;

    private String model;

    private String prettyName;

    private String engine;

    private String fuelType;

    private Date endOfInsurance;

    private Date endOfTechnicalInspection;

}
