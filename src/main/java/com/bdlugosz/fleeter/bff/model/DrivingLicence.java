package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrivingLicence {

    @Id
    public String id;

    List<String> categoryList;
    String licenceNumber;
    LocalDate expirationDate;
}
