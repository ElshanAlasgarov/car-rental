package com.project.carrental.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class CarResponseDto {

    private Long carId;

    private Long merchantId;

    private String merchantName;

    private String model;

    private String brand;

    private String color;

    private Integer year;

    private Boolean isAvailable;

    private Double pricePerDay;

    private String image;

}
