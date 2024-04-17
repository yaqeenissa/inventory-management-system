package com.example.webServises.reposirory;

import com.example.webServises.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepositoryInt extends MongoRepository<Customer, String> {

}
