package com.accelex.sample.exercise.mapper;

import com.accelex.sample.exercise.domain.Customer;
import com.accelex.sample.exercise.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer map(CustomerDto dto){
        Customer model = new Customer();
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setBirthDate(dto.getBirthDate());
        model.setDriverLicenseNumber(dto.getDriverLicenseNumber());
        return model;
    }

    public CustomerDto map(Customer model){
        CustomerDto dto = new CustomerDto();
        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setBirthDate(model.getBirthDate());
        dto.setDriverLicenseNumber(model.getDriverLicenseNumber());
        return dto;
    }

    public List<CustomerDto> map(List<Customer> models){
        return models.stream().map(this::map).collect(Collectors.toList());
    }

}
