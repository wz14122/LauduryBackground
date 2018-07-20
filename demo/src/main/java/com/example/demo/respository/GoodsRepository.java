package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {

}
