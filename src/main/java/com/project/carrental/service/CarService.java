package com.project.carrental.service;

import com.project.carrental.domain.entity.Car;
import com.project.carrental.domain.entity.User;
import com.project.carrental.model.dto.request.AddCarRequest;
import com.project.carrental.model.dto.request.UpdateCarRequest;
import com.project.carrental.model.dto.response.CarResponseDto;

import java.util.List;

public interface CarService {

    CarResponseDto addCar(AddCarRequest request, String email);

    CarResponseDto updateCar(Long carId, UpdateCarRequest car, String email);

    void deleteCar(String email, Long carId);

    List<CarResponseDto> getAllAvailableCars();

    List<CarResponseDto> getCarsByMerchant(User user);
}
