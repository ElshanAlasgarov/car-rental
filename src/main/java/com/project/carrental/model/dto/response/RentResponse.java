package com.project.carrental.model.dto.response;

import com.project.carrental.domain.entity.Car;
import com.project.carrental.domain.entity.User;
import com.project.carrental.model.enums.RentalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class RentResponse {

    private LocalDateTime rentalDate;

    private RentalStatus status;

    private String carModel;

    private String carBrand;

    private String carColor;

    private Integer carYear;

    private Double pricePerDay;

    private String customerName;

    private String customerPhoneNumber;

    private String merchantName;

    private String merchantPhoneNumber;
}
