package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.Customer;
import com.example.demo.moudle.MyException;
import com.example.demo.moudle.ResultEnum;



@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;
	
	private static final Logger logger = LoggerFactory.logger(CustomerService.class);
	
	public Customer save(Customer entity) {
		return dao.save(entity);
	}
	
	public void deleteById(Integer id) {
		try {
			dao.deleteById(id);
		} catch (Exception e) {
			logger.error(e);
			throw new MyException(ResultEnum.SYSTEM_ERROR);
		}
	}
	
	public void delete(Customer entity) {
		dao.delete(entity);
	}
	
	public Customer update(Customer entity) {
		return dao.save(entity);
	}
	
	public List<Customer> findAll() {
		return dao.findAll();
	}

	public Optional<Customer> findById(Integer id) {
		return dao.findById(id);
	}
	
	public Optional<Customer> findByCustomerName(String customerName){
		return dao.findByCustomerName(customerName);
	}
}
