package com.example.webServises.reposirory;

import com.example.webServises.entity.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendorReposetory extends MongoRepository<Vendor, String> {
}
