package com.example.webServises.Controller.vendor;

import com.example.webServises.dto.VendorDto;
import com.example.webServises.service.Vendor.VendorServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Vendor")
public class VendorResource {

    VendorServiceImp vendorServiceImp;

    private final Logger log = LoggerFactory.getLogger(VendorResource.class);

    public VendorResource(VendorServiceImp vendorServiceImp){
        this.vendorServiceImp=vendorServiceImp;
    }
    @GetMapping(value="/all")
    public ResponseEntity<List<VendorDto>> getAll(){
        return ResponseEntity.ok().body(vendorServiceImp.getAllVendor());
    }
    @GetMapping
    public VendorDto getById(@RequestParam String id){
        return vendorServiceImp.getVendorById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorDto> update(
            @Valid @RequestBody VendorDto vendorDto,
            @PathVariable(name="id") String id) {
        VendorDto updatedVendorDto = vendorServiceImp.updateVendor(vendorDto, id);
        return new ResponseEntity<>( updatedVendorDto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name="id") String id) {
        vendorServiceImp.deleteVendorById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<VendorDto> create(
            @Valid @RequestBody VendorDto vendorDto){

//        if(customerDto.getID()!=null){
//            log.error("enter the id ",customerDto);
//            throw new BadRequestException(CustomerResource.class.getSimpleName(),
//                    "name");
//
//        }
//        if(customerDto.getName() == null){
//            log.error("Cannot have an name {}", customerDto);
//            throw new BadRequestException(CustomerResource.class.getSimpleName(),"Name");
//        }
        return new ResponseEntity(vendorServiceImp.CreateVendor(vendorDto), HttpStatus.CREATED);

    }
}
