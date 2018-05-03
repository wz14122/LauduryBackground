package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.ClothType;

public interface ClothTypeRepository extends JpaRepository<ClothType, Integer> {

	@Query(value = "SELECT CT.cloth_type_name,C.cloth_name,C.price FROM cloth_type AS CT LEFT JOIN cloth AS C ON CT.cloth_type_id = C.cloth_type_id;", nativeQuery = true)
	List<Object> getListLeftJoinCloth();
}
