package com.example.webServises.Controller.customer;


import com.example.webServises.dto.CustomerDto;
import com.example.webServises.service.customer.CustomerServiceIMp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController{

    CustomerServiceIMp customerServiceIMp;
    @GetMapping(value="/Customers")
    public CustomerDto getCustomer(){
        return new CustomerDto("100","ahmad","ahm123","@123");
    }

    @GetMapping(value="customers")
    public List<CustomerDto> getCustomers(){

        List<CustomerDto> customerList=new ArrayList<>();
        for(int i=0;i<5;i++){
            customerList.add(new CustomerDto("1000"+i,"name"+i,"username"+i,"pass"+i));
        }
        return customerList;
    }

    @GetMapping(value = "Customer/{Name}/{username}")
    public ResponseEntity<CustomerDto> getCustomerReqParam(@RequestParam("Name") String Name,@RequestParam("usarName")String userName){
        return ResponseEntity.ok(new CustomerDto(Name,userName));
    }


    @PutMapping(value = "/Customer/{id}")
    public ResponseEntity<CustomerDto> updateCustomerByNameAndUsername(
            @Valid @RequestBody CustomerDto customerDto,
            @PathVariable("id") String id
            ) {

        // Retrieve the customer by name and username
        CustomerDto existingCustomer = customerServiceIMp.getCustomerById(id);

        // Check if the customer exists
        if (existingCustomer == null) {
            // If the customer does not exist, return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }

        // Update the customer information with the provided data
        existingCustomer.setName(customerDto.getName());
        existingCustomer.setUserName(customerDto.getUserName());
        // You can update other fields as needed

        // Save the updated customer
        CustomerDto updatedCustomer = customerServiceIMp.updateCustomer(existingCustomer,id);

        // Return a response with the updated customer information
        return ResponseEntity.ok(updatedCustomer);
    }


}
