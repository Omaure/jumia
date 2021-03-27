package com.jumia.PhoneNumber.core.repo;

import com.jumia.PhoneNumber.core.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhoneNumberRepo extends JpaRepository<Customer, Integer> {}
