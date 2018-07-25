package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {

	List<Goods> findByConsumptionId(String consumptionId);
	
	List<Goods> findByHaveFetch(boolean fetchState);
	
	@Modifying
	@Query("update Goods AS g SET g.haveFetch = true, g.fetchDate = NOW() where g.goodsId in :ids")
	void updateGoodsStateByIds(@Param(value = "ids") List<Integer> ids);
	
}
