package com.project.carrental.controller;

import com.project.carrental.domain.entity.Car;
import com.project.carrental.domain.entity.User;
import com.project.carrental.model.dto.request.AddCarRequest;
import com.project.carrental.model.dto.request.UpdateCarRequest;
import com.project.carrental.model.dto.response.CarResponseDto;
import com.project.carrental.security.JwtService;
import com.project.carrental.service.CarService;
import com.project.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;
    private final UserService userService;

    @GetMapping("/available")
    public ResponseEntity<List<CarResponseDto>> getAllAvailableCars() {
        return ResponseEntity.ok(carService.getAllAvailableCars());
    }

    @PostMapping("/add")
    public ResponseEntity<CarResponseDto> addCar(
            @RequestBody AddCarRequest request,
            @AuthenticationPrincipal UserDetails userDetails
            ) {
        return ResponseEntity.ok(carService.addCar(request, userDetails.getUsername()));
    }

    @PostMapping("/update")
    public ResponseEntity<CarResponseDto> updateCar(
            @RequestHeader("carId") Long carId,
            @RequestBody UpdateCarRequest request,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.ok(carService.updateCar(carId, request, userDetails.getUsername()));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCar(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestHeader("carId") Long carId
    ) {
        carService.deleteCar(userDetails.getUsername(), carId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-merchant")
    public ResponseEntity<List<CarResponseDto>> getCarsByMerchant(@AuthenticationPrincipal UserDetails userDetails) {

        User user = userService.getUserByEmail(userDetails.getUsername());

        return ResponseEntity.ok(carService.getCarsByMerchant(user));
    }
}
