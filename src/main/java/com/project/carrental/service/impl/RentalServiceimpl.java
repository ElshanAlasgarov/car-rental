package com.project.carrental.service.impl;

import com.project.carrental.domain.entity.Car;
import com.project.carrental.domain.entity.Rental;
import com.project.carrental.domain.entity.User;
import com.project.carrental.domain.repository.CarRepository;
import com.project.carrental.domain.repository.RentalRepository;
import com.project.carrental.domain.repository.UserRepository;
import com.project.carrental.exception.AlreadyExistsException;
import com.project.carrental.exception.NotFoundException;
import com.project.carrental.mapper.RentalMapper;
import com.project.carrental.model.dto.response.RentResponse;
import com.project.carrental.model.dto.response.ReturnResponse;
import com.project.carrental.model.enums.RentalStatus;
import com.project.carrental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceimpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final RentalMapper rentalMapper;

    @Override
    public RentResponse rentCar(String customerEmail, Long carId) {
        User customer = findUserByEmail(customerEmail);
        checkActiveRental(customer);

        Car car = findCarById(carId);
        checkCarAvailability(car);

        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setCar(car);
        rental.setRentalDate(LocalDateTime.now());
        rental.setStatus(RentalStatus.ACTIVE);
        car.setIsAvailable(false);
        carRepository.save(car);

        return rentalMapper.toDto(rentalRepository.save(rental));
    }

    @Override
    public ReturnResponse returnCar(String customerEmail) {
        User user = findUserByEmail(customerEmail);

        Rental rental = rentalRepository
                .findByCustomerAndStatus(user, RentalStatus.ACTIVE)
                .orElseThrow(() -> new RuntimeException("User does not have an active rental"));
        rental.setReturnDate(LocalDateTime.now());
        rental.setStatus(RentalStatus.COMPLETED);

        Car car = rental.getCar();
        car.setIsAvailable(true);
        carRepository.save(car);

        Double fee = Duration.between(rental.getRentalDate(),
                rental.getReturnDate()).toDays() * car.getPricePerDay();
        rental.setFee(fee);

        return rentalMapper.toReturnDto(rentalRepository.save(rental));
    }

    @Override
    public List<ReturnResponse> getRentalHistory(String email) {
        User user = findUserByEmail(email);
        return rentalRepository.findByCustomer(user).stream()
                .map(rental -> rentalMapper.toReturnDto(rental))
                .toList();
    }

    private User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found with email: " + email));
    }

    private Car findCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found with id: " + id));
    }

    private void checkActiveRental(User customer) {
        rentalRepository.findByCustomerAndStatus(customer, RentalStatus.ACTIVE)
                .ifPresent(rental -> {
                    throw new AlreadyExistsException("User already has an active rental");
                });
    }

    private void checkCarAvailability(Car car) {
        if (!car.getIsAvailable()) {
            throw new NotFoundException("Car is not available");
        }
    }
}
