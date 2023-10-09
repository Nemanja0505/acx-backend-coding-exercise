package com.accelex.sample.exercise.service.interfaces;

import com.accelex.sample.exercise.domain.Customer;
import com.accelex.sample.exercise.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);
    List<CustomerDto> getAll();
}
