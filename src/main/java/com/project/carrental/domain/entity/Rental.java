package com.project.carrental.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carrental.model.enums.RentalStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime rentalDate;

    private LocalDateTime returnDate;

    @Enumerated(EnumType.STRING)
    private  RentalStatus status;

    private Double fee;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

}
