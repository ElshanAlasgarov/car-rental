package com.project.carrental.model.dto.response;

import com.project.carrental.model.enums.RentalStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder @Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ReturnResponse {

    private LocalDateTime returnDate;

    private LocalDateTime rentalDate;

    private Double fee;

    private RentalStatus status;

    private String customerName;

    private String customerPhoneNumber;

    private CarResponseDto car;

}
