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
public class CarsController {

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

    @GetMapping(value = "/cars")
    @ApiOperation(value = "Get a CarsSection objects with car lists which belongs to user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<CarsSection> carsSection() {
        CarsSection carsSection = homeService.getCarsSection(getFirebaseUserDetails().getId());
        return ResponseEntity.ok(carsSection);
    }

    @GetMapping(value = "/car/basic/{id}")
    @ApiOperation(value = "Get a CarBasicInfo objects with car basic info")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<CarBasicInfo> carBasicInfo(@PathVariable("id") String id) {
        CarBasicInfo carBasicInfo = homeService.getCarBasicInfo(id);
        return ResponseEntity.ok(carBasicInfo);
    }

    @GetMapping(value = "/car/{id}")
    @ApiOperation(value = "Get a CarDetails objects with car details")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<CarDetails> carDetails(@PathVariable("id") String id) {
        CarDetails carDetails = homeService.getCarDetails(id);
        return ResponseEntity.ok(carDetails);
    }

    @PostMapping(value = "/car/{id}")
    @ApiOperation(value = "Lease a car with id in path")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<String> leaseCar(@PathVariable("id") String id) {
        String value = homeService.leaseCar(id, getFirebaseUserDetails().getId());
        return ResponseEntity.ok(value);
    }

    @GetMapping(value = "/cars/available")
    @ApiOperation(value = "Get a AvailableCars objects with car lists which could be taken by user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<AvailableCars> availableCars() {
        AvailableCars availableCars = homeService.getAvailableCars();
        return ResponseEntity.ok(availableCars);
    }
}