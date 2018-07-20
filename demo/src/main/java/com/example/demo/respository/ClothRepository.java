package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Cloth;

public interface ClothRepository extends JpaRepository<Cloth, Integer> {

	List<Cloth> findByClothTypeCode(int clothTypeId);
}
