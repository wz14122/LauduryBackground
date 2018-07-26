package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ColorDao;
import com.example.demo.entity.Color;

@Service
public class ColorService {

	@Autowired
	private ColorDao dao;

	public List<Color> findAll() {
		return dao.findAll();
	}

	public Color save(String colorName) {
		String type = colorName.trim();
		Optional<Color> exist = dao.findByType(type);
		Color color = new Color(type);
		return exist.orElseGet(() -> dao.save(color));
	}
	
}
