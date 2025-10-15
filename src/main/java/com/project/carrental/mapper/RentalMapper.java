package com.project.carrental.mapper;

import com.project.carrental.domain.entity.Rental;
import com.project.carrental.model.dto.response.RentResponse;
import com.project.carrental.model.dto.response.ReturnResponse;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {

    public static RentResponse toDto(Rental rental) {
        return RentResponse.builder()
                .merchantName(rental.getCar().getMerchant().getFirstName())
                .customerName(rental.getCustomer().getFirstName())
                .pricePerDay(rental.getCar().getPricePerDay())
                .rentalDate(rental.getRentalDate())
                .status(rental.getStatus())
                .carBrand(rental.getCar().getBrand())
                .carModel(rental.getCar().getModel())
                .carYear(rental.getCar().getYear())
                .carColor(rental.getCar().getColor())
                .customerPhoneNumber(rental.getCustomer().getPhoneNumber())
                .merchantPhoneNumber(rental.getCar().getMerchant().getPhoneNumber())
                .build();
    }

    public static ReturnResponse toReturnDto(Rental rental) {
        return ReturnResponse.builder()
                .rentalDate(rental.getRentalDate())
                .returnDate(rental.getReturnDate())
                .status(rental.getStatus())
                .fee(rental.getFee())
                .car(CarMapper.toDto(rental.getCar()))
                .customerName(rental.getCustomer().getFirstName())
                .customerPhoneNumber(rental.getCustomer().getPhoneNumber())
                .build();
    }
}
