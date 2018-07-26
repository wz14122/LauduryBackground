package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cloth;
import com.example.demo.entity.ClothType;
import com.example.demo.entity.Color;
import com.example.demo.moudle.MyException;
import com.example.demo.moudle.ResultEnum;

@Service
public class BasicDataMantenceService {

	@Autowired
	private ClothService cService;

	@Autowired
	private ClothTypeService ctService;
	
	@Autowired
	private ColorService colorService;

	/**
	 * @return hashmap所有清洗类型，及其孩子项。注意，不是二级目录结构！
	 */
	@Transactional
	public HashMap<String, List<?>> allClothMsg() {

		HashMap<String, List<?>> clothMsgMap = new HashMap<>();

		List<ClothType> clothType = ctService.findAll();
		clothMsgMap.put("ClothType", clothType);
		for (ClothType ct : clothType) {
			List<Cloth> c = cService.findByClothTypeCode(Optional.ofNullable(ct.getClothTypeCode())
					.orElseThrow(() -> new MyException(ResultEnum.CONDITION_EMPTY)));
			clothMsgMap.put(ct.getClothTypeCode() + "", c);
		}
		return clothMsgMap;
	}
	
	public List<Color> allColor() {
		return colorService.findAll();
	}
	
	public Color addColor(String color) {
		return colorService.save(color);
	}
	
}
