package com.project.carrental.model.dto.request;

import lombok.Data;

@Data
public class UpdateCarRequest {

    private String model;

    private String brand;

    private String color;

    private Integer year;

    private Double pricePerDay;

    private String image;

    private Boolean isAvailable;

}
