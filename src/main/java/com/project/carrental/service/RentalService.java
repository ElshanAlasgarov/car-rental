package com.project.carrental.service;

import com.project.carrental.domain.entity.Rental;
import com.project.carrental.domain.entity.User;
import com.project.carrental.model.dto.response.RentResponse;
import com.project.carrental.model.dto.response.ReturnResponse;

import java.util.List;

public interface RentalService {

    RentResponse rentCar(String customerEmail, Long carId);

    ReturnResponse returnCar(String customerEmail);

    List<ReturnResponse> getRentalHistory(String email);

}
