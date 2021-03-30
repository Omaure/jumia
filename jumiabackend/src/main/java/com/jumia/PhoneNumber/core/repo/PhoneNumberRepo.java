package com.jumia.PhoneNumber.core.repo;

import com.jumia.PhoneNumber.core.models.Customer;
import org.springframework.data.repository.CrudRepository;


public interface PhoneNumberRepo extends CrudRepository<Customer, Integer> { }
