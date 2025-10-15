package com.project.carrental.controller;

import com.project.carrental.domain.entity.Rental;
import com.project.carrental.model.dto.response.RentResponse;
import com.project.carrental.model.dto.response.ReturnResponse;
import com.project.carrental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @PostMapping("/rent")
    public ResponseEntity<RentResponse> rentCar(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestHeader Long carId
    ) {
        return ResponseEntity.ok(rentalService.rentCar(userDetails.getUsername(), carId));
    }

    @PostMapping("/return")
    public ResponseEntity<ReturnResponse> returnCar(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.ok(rentalService.returnCar(userDetails.getUsername()));
    }

    @GetMapping("/history")
    public ResponseEntity<List<ReturnResponse>> getRentalHistory(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.ok(rentalService.getRentalHistory(userDetails.getUsername()));
    }
}
