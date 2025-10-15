package com.project.carrental.mapper;

import com.project.carrental.domain.entity.Car;
import com.project.carrental.model.dto.request.AddCarRequest;
import com.project.carrental.model.dto.request.UpdateCarRequest;
import com.project.carrental.model.dto.response.CarResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public static CarResponseDto toDto(Car car) {
        return CarResponseDto.builder()
                .carId(car.getCarId())
                .model(car.getModel())
                .brand(car.getBrand())
                .color(car.getColor())
                .year(car.getYear())
                .isAvailable(car.getIsAvailable())
                .pricePerDay(car.getPricePerDay())
                .image(car.getImage())
                .merchantId(car.getMerchant().getUserId())
                .merchantName(car.getMerchant().getFirstName())
                .build();
    }

    public Car toEntity(AddCarRequest request) {
        return Car.builder()
                .model(request.getModel())
                .brand(request.getBrand())
                .color(request.getColor())
                .year(request.getYear())
                .isAvailable(request.getIsAvailable())
                .pricePerDay(request.getPricePerDay())
                .image(request.getImage())
                .build();
    }

    public Car toEntity(UpdateCarRequest request) {
        return Car.builder()
                .model(request.getModel())
                .brand(request.getBrand())
                .color(request.getColor())
                .year(request.getYear())
                .isAvailable(request.getIsAvailable())
                .pricePerDay(request.getPricePerDay())
                .image(request.getImage())
                .build();
    }
}
