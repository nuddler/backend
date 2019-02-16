package com.bdlugosz.fleeter.bff;


import com.bdlugosz.fleeter.bff.model.CarsSection;
import com.bdlugosz.fleeter.bff.model.GreetingsSection;
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

import javax.websocket.server.PathParam;

@Data
@RestController
@RequestMapping(value = "/api")
@Api
@Log4j2
public class HomeController {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private HomeService homeService;

    @GetMapping(value = "/greetings")
    @ApiOperation(value = "Get a GreetingsSection object.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<GreetingsSection> greetingsSection() {
        GreetingsSection greetingsSection = greetingService.getGreetingsSection();
        return ResponseEntity.ok(greetingsSection);
    }


    @GetMapping(value = "/teasers")
    @ApiOperation(value = "Get a TeasersListSection objects with teaser lists to show below cars section.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<TeasersListSection> teasersSection() {
        TeasersListSection leadsLists = homeService.getTeasersListsSection();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.error(authentication.getPrincipal());
        return ResponseEntity.ok(leadsLists);
    }

    @GetMapping(value = "/cars")
    @ApiOperation(value = "Get a CarsSection objects with car lists which belongs to user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation."),
            @ApiResponse(code = 403, message = "User is not authorized to use this resource."),
            @ApiResponse(code = 500, message = "A generic error indication for an unexpected server execution problem.")})
    public ResponseEntity<CarsSection> carsSection() {
        CarsSection carsSection = homeService.getCarsSection("uid");
        return ResponseEntity.ok(carsSection);
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