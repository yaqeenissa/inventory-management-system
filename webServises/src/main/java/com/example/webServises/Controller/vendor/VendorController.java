package com.example.webServises.Controller.vendor;


import com.example.webServises.dto.CustomerDto;
import com.example.webServises.dto.VendorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VendorController {
    @GetMapping(value="/Vendor")
    public VendorDto getvendor(){
        return new VendorDto("sama","soso_K","@123");
    }
    public List<VendorDto> getvendors(){

        List<VendorDto> vendorList=new ArrayList<>();
        for(int i=0;i<5;i++){
            vendorList.add(new VendorDto("name"+i,"username"+i,"pass"+i));
        }
        return vendorList;
    }

    @GetMapping(value = "/Vendor/{Name}/{username}")
    public ResponseEntity<VendorDto> getCustomerReqParam(@RequestParam("Name") String Name,@RequestParam("UsarName")String userName){
        return ResponseEntity.ok(new VendorDto(Name,userName));
    }
}