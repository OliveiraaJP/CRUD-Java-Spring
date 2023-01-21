package com.carsapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carsapi.api.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}
