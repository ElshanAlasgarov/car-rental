package com.project.carrental.domain.repository;

import com.project.carrental.domain.entity.Rental;
import com.project.carrental.domain.entity.User;
import com.project.carrental.model.enums.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    Optional<Rental> findByCustomerAndStatus(User customer, RentalStatus status);

    Optional<Rental> findByCustomerUserIdAndStatus(Long userId, RentalStatus status);

    List<Rental> findByCustomer(User customer);

}
