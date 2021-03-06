package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    public String id;

    String firstName;
    String lastName;

    Address userAddress;
    Address contactAddress;
    String phoneNumber;
    String email;

    BillingData billingData;
    DrivingLicence licence;

}
