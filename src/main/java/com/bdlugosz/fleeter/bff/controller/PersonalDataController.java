package com.bdlugosz.fleeter.bff.controller;


import com.bdlugosz.fleeter.bff.model.*;
import com.bdlugosz.fleeter.bff.security.FirebaseUserDetails;
import com.bdlugosz.fleeter.bff.service.GreetingService;
import com.bdlugosz.fleeter.bff.service.HomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping(value = "/api")
@Api
@Log4j2
public class PersonalDataController {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private HomeService homeService;

    private FirebaseUserDetails getFirebaseUserDetails() {
        FirebaseUserDetails userDetails;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userDetails = (FirebaseUserDetails) authentication.getPrincipal();
        return userDetails;
    }

    @GetMapping(value = "/personalData")
    @ApiOperation(value = "Get a PersonalDataSection objects with user's personal data such a address, phone, bank account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<PersonalDataSection> personalSection() {
        PersonalDataSection personalDataSection = homeService.getPersonalDataSection(getFirebaseUserDetails().getId());
        return ResponseEntity.ok(personalDataSection);
    }

}