package com.shuravi.msscbrewery.services.impl;

import com.shuravi.msscbrewery.services.CustomerService;
import com.shuravi.msscbrewery.web.model.CustomerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDto getCustomerById(UUID customerId) {
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .name("Shuravi")
        .build();
  }

  @Override
  public CustomerDto saveNewCustomer(CustomerDto customerDto) {
    return CustomerDto.builder()
        .id(UUID.randomUUID())
        .build();
  }

  @Override
  public void updateCustomer(UUID customerId, CustomerDto customerDto) {
    // TODO: 11-05-2023 : update customer
    log.debug("Updating customer");
  }

  @Override
  public void deleteById(UUID customerId) {
    // TODO: 11-05-2023 : delete customer
    log.debug("Deleting customer");
  }

}
