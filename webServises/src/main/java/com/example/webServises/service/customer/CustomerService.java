package com.example.webServises.service.customer;

import com.example.webServises.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto CreateCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();
    CustomerDto getCustomerById(String id);
    CustomerDto updateCustomer(CustomerDto customerDto,String id);
    void deleteCustomerById(String id);
}
