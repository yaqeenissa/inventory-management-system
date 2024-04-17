package com.example.webServises.service.customer;

import com.example.webServises.dto.CustomerDto;
import com.example.webServises.entity.Customer;
import com.example.webServises.exception.ResourceNotFoundException;
import com.example.webServises.reposirory.CustomerRepositoryInt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceIMp implements CustomerService {

    private final CustomerRepositoryInt customerRepository;

    public CustomerServiceIMp(CustomerRepositoryInt customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto CreateCustomer(CustomerDto customerDto) {

        //convert Dto to entity
        Customer customer=mapToEntity(customerDto);
        Customer newCustomer=customerRepository.save(customer);

        //convert entity to DTo
        CustomerDto customerResponse =mapToDto(newCustomer);

        return customerResponse;
    }

    //convert entity to dto
    private CustomerDto mapToDto(Customer customer) {
        CustomerDto customerDto=new CustomerDto();

        customerDto.setID(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setUserName(customer.getUserName());
        customerDto.setPassword(customer.getPassword());
        return customerDto;

    }

    //convert Dto to entity
    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer=new Customer();
        customer.setId(customerDto.getID());
        customer.setName(customerDto.getName());
        customer.setUserName(customerDto.getUserName());
        customer.setPassword(customerDto.getPassword());
        return customer;
    }


    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> customers=customerRepository.findAll();

        return customers.stream().map(customer -> mapToDto(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(String id) {
        Customer customer=customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","id",id));
        return mapToDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto,String id) {
        Customer customer=customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","id",id));
        customer.setName(customerDto.getName());
//        customer.setUserName(customerDto.getUserName());
//        customer.setPassword(customerDto.getPassword());

        Customer updatedCustomer=customerRepository.save(customer);
        return mapToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(String id) {
        Customer customer=customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));

        customerRepository.delete(customer);
    }


}
