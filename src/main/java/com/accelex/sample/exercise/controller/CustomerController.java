package com.accelex.sample.exercise.controller;

import com.accelex.sample.exercise.dto.CustomerDto;
import com.accelex.sample.exercise.service.interfaces.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerDto dto){
        CustomerDto savedCustomer = customerService.saveCustomer(dto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }



}
