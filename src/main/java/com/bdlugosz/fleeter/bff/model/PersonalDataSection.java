package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalDataSection {

    String firstName;
    String lastName;

    Address userAddress;
    Address contactAddress;
    String phoneNumber;
    String email;

    BillingData billingData;
    DrivingLicence licence;
}
