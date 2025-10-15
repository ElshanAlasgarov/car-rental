package com.project.carrental.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class AddCarRequest {

    private String model;

    private String brand;

    private String color;

    private Integer year;

    private Boolean isAvailable;

    private Double pricePerDay;

    private String image;
}
