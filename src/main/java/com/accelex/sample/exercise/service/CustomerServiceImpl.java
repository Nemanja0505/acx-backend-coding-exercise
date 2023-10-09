package com.accelex.sample.exercise.service;

import com.accelex.sample.exercise.domain.Customer;
import com.accelex.sample.exercise.dto.CustomerDto;
import com.accelex.sample.exercise.mapper.CustomerMapper;
import com.accelex.sample.exercise.repository.CustomerRepository;
import com.accelex.sample.exercise.service.interfaces.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.save(mapper.map(customerDto));
        return mapper.map(customer);
    }

    @Override
    public List<CustomerDto> getAll() {
        return mapper.map(customerRepository.findAll());
    }

}
