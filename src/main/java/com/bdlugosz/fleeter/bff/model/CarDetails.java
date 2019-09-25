package com.bdlugosz.fleeter.bff.model;

import com.bdlugosz.fleeter.bff.model.Car;
import com.bdlugosz.fleeter.bff.model.Feature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDetails {

    public String id;

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

    public CarDetails(Car car) {
        id = car.getId();
        working = car.isWorking();
        description = car.getDescription();
        name = car.getName();
        iconUrl = car.getIconUrl();
        iconTitle = car.getIconTitle();
        totalMileage = car.getTotalMileage();
        colour = car.getColour();
        brand = car.getBrand();
        model = car.getModel();
        prettyName = car.getPrettyName();
        engine = car.getEngine();
        fuelType = car.getFuelType();
        endOfInsurance = car.getEndOfInsurance();
        endOfTechnicalInspection = car.getEndOfTechnicalInspection();
        features = car.getFeatures();
    }
}
