package com.project.carrental.service.impl;

import com.project.carrental.domain.entity.Car;
import com.project.carrental.domain.entity.User;
import com.project.carrental.domain.repository.CarRepository;
import com.project.carrental.domain.repository.UserRepository;
import com.project.carrental.exception.NotFoundException;
import com.project.carrental.exception.UnauthorizedExceptionHandler;
import com.project.carrental.mapper.CarMapper;
import com.project.carrental.model.dto.request.AddCarRequest;
import com.project.carrental.model.dto.request.UpdateCarRequest;
import com.project.carrental.model.dto.response.CarResponseDto;
import com.project.carrental.model.enums.Role;
import com.project.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final CarMapper carMapper;

    @Override
    public CarResponseDto addCar(AddCarRequest request, String email) {
        User user = userRepository.findByEmail(email).get();
        if ((user.getRole() != Role.MERCHANT)) {

            throw new UnauthorizedExceptionHandler("User is not a merchant");
        }
        Car car = carMapper.toEntity(request);
        car.setMerchant(user);
        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public CarResponseDto updateCar(Long carId, UpdateCarRequest car, String email) {
        Car car1 = validateCarOwnership(carId, email);

        car1.setBrand(car.getBrand());
        car1.setModel(car.getModel());
        car1.setColor(car.getColor());
        car1.setYear(car.getYear());
        car1.setPricePerDay(car.getPricePerDay());
        car1.setImage(car.getImage());

        return carMapper.toDto(carRepository.save(car1));
    }

    @Override
    public void deleteCar(String email, Long carId) {
        Car car = validateCarOwnership(carId, email);
        carRepository.delete(car);
    }

    @Override
    public List<CarResponseDto> getAllAvailableCars() {
        if (carRepository.findByIsAvailable(true).isEmpty()) {
            throw new NotFoundException("No cars available");
        }
        return carRepository.findByIsAvailable(true).stream()
                .map(car -> carMapper.toDto(car))
                .toList();
    }

    @Override
    public List<CarResponseDto> getCarsByMerchant(User user) {


        return carRepository.findByMerchant(user).stream()
                .map(car -> carMapper.toDto(car))
                .toList();
    }

    private Car validateCarOwnership(Long carId, String email) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new NotFoundException("Car not found with id: " + carId));

        if (!car.getMerchant().getEmail().equals(email)) {
            throw new UnauthorizedExceptionHandler("User is not authorized to modify this car");
        }

        return car;
    }

}
