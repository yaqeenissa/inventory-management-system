package com.example.webServises.reposirory;

import com.example.webServises.entity.Item;
import com.example.webServises.entity.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
