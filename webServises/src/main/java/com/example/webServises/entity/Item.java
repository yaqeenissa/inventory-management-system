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
@Document(collection = "Item")
public class Item implements Serializable {
    @Id
    private String id; // Use String type for MongoDB's ObjectId
    @DBRef
    private Order idOrder;
    @DBRef
    private Vendor idVendor;

    private int price;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Order idOrder) {
        this.idOrder = idOrder;
    }

    public Vendor getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(Vendor idVendor) {
        this.idVendor = idVendor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
