package com.example.demo.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>{

	public Optional<Color> findByType(String type);
}
