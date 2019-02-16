package com.bdlugosz.fleeter.bff;

import com.bdlugosz.fleeter.bff.model.CarBasicInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableCars {
    private List<CarBasicInfo> carList;
}
