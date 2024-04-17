package com.example.webServises.dto;

import com.example.webServises.entity.Order;
import com.example.webServises.entity.Vendor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {


    private String id; // Use String type for MongoDB's ObjectId

    private Order idOrder;

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    private String itemName;
}

