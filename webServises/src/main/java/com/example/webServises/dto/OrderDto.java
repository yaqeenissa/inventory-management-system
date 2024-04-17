package com.example.webServises.dto;

import com.example.webServises.entity.Customer;
import com.example.webServises.entity.Item;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class OrderDto {

    @Id
    private String id; // Use String type for MongoDB's ObjectId

    private Item itemId;

    private Customer customerId;

    private int quantity;
}
