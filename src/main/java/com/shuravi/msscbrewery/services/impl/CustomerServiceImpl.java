package com.shuravi.msscbrewery.services.impl;

import com.shuravi.msscbrewery.services.CustomerService;
import com.shuravi.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Shuravi")
                .build();
    }

}
