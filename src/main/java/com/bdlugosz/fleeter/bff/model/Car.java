package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    public String id;

    private boolean taken;

    private String takenBy;

    private boolean working;

    private String description;

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

    private LocalDate endOfInsurance;

    private LocalDate endOfTechnicalInspection;

    private List<Feature> features;
}
