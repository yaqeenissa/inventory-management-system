package com.example.webServises.Controller.customer;
import com.example.webServises.dto.CustomerDto;
import com.example.webServises.service.customer.CustomerService;
import com.example.webServises.service.customer.CustomerServiceIMp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Customer")
public class CustomerResource {
    @Autowired
    CustomerServiceIMp customerServiceIMp;
    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);
    public CustomerResource(CustomerServiceIMp customerServiceIMp) {
        this.customerServiceIMp = customerServiceIMp;
    }

    @GetMapping(value = "/{Name}/{username}")
    public ResponseEntity<CustomerDto> getCustomerReqParam(@RequestParam("Name") String Name,@RequestParam("usarName")String userName){
        return ResponseEntity.ok(new CustomerDto(Name,userName));
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok().body(customerServiceIMp.getAllCustomer());
    }
    @GetMapping("/{id}")
    public CustomerDto getCusById(@RequestParam String id){
        return customerServiceIMp.getCustomerById(id);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(
            @Valid @RequestBody CustomerDto customerDto,
            @PathVariable(name="id") String id) {

         return new ResponseEntity<>(customerServiceIMp.updateCustomer(customerDto,id) ,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable(name="id") String id) {
        customerServiceIMp.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(
            @Valid @RequestBody CustomerDto customerDto) {

        if (customerDto.getID() != null) {
            log.error("Invalid request: ID should not be provided for creating a new customer.");
        }

        if (customerDto.getName() == null) {
            log.error("Invalid request: Customer name is required.");
        }

        CustomerDto createdCustomer = customerServiceIMp.CreateCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);

    }



}
