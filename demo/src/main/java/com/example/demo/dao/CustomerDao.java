package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.respository.CustomerRepository;

@Service
public class CustomerDao {

	@Autowired
	private CustomerRepository repository;
	
	public Customer save(Customer entity) {
		return repository.save(entity);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public void delete(Customer entity) {
		repository.delete(entity);
	}
	
	public Customer update(Customer entity) {
		return repository.save(entity);
	}
	
	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Optional<Customer> findById(Integer id) {
		return repository.findById(id);
	}
	
	public Optional<Customer> findByCustomerName(String customerName){
		return repository.findByCustomerName(customerName);
	}
}
