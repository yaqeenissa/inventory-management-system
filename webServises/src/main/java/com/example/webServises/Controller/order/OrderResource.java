package com.example.webServises.Controller.order;

import com.example.webServises.Controller.customer.CustomerResource;
import com.example.webServises.dto.CustomerDto;
import com.example.webServises.dto.OrderDto;
import com.example.webServises.dto.VendorDto;
import com.example.webServises.service.Order.OrderServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Order")
public class OrderResource {

    OrderServiceImp orderServiceImp;

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    public OrderResource(OrderServiceImp orderServiceImp){
        this.orderServiceImp=orderServiceImp;
    }

    @GetMapping(value="/all")
    public ResponseEntity<List<OrderDto>> getAllCustomer(){
        return ResponseEntity.ok().body(orderServiceImp.getAll());
    }

    @GetMapping
    public OrderDto getCusById(@RequestParam String id){
        return orderServiceImp.getById(id);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderServiceImp.Create(orderDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name="id") String id) {
        orderServiceImp.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> update(
            @Valid @RequestBody OrderDto vendorDto,
            @PathVariable(name="id") String id) {
        OrderDto updatedVendorDto = orderServiceImp.update(vendorDto, id);
        return new ResponseEntity<>( updatedVendorDto,HttpStatus.OK);
    }

}
