package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Consumption;

public interface ConsumptionRepository extends JpaRepository<Consumption, Integer> {

}
