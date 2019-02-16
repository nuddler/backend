package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarsSection {

    private String headline;

    private List<CarBasicInfo> carList;
}
