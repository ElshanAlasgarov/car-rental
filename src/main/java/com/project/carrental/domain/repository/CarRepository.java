package com.project.carrental.domain.repository;

import com.project.carrental.domain.entity.Car;
import com.project.carrental.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByMerchant(User merchant);

    List<Car> findByIsAvailable(Boolean isAvailable);

    void deleteByMerchant_Email(String merchantEmail);
}
