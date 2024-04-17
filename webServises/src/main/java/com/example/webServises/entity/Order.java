package com.example.webServises.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Order")
public class Order implements Serializable {
    @Id
    private String id; // Use String type for MongoDB's ObjectId
    @DBRef
    private Item itemId;
    @DBRef
    private Customer customerId;

    private int quantity;


}
