package com.example.webServises.service.Vendor;

import com.example.webServises.dto.CustomerDto;
import com.example.webServises.dto.VendorDto;
import com.example.webServises.entity.Customer;
import com.example.webServises.entity.Vendor;
import com.example.webServises.exception.ResourceNotFoundException;
import com.example.webServises.reposirory.VendorReposetory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImp implements VendorService {
    private VendorReposetory vendorRepository;


        public VendorServiceImp(VendorReposetory vendorReposetory){
            this.vendorRepository=vendorReposetory;
        }
    @Override
    public VendorDto CreateVendor(VendorDto vendorDto) {
        //convert Dto to entity
        Vendor vendor=mapToEntity(vendorDto);
        Vendor newVendor=vendorRepository.save(vendor);
        //convert entity to DTo
        VendorDto Response =mapToDto(newVendor);

        return mapToDto(newVendor);
    }


    @Override
    public List<VendorDto> getAllVendor() {
            List<Vendor> Vendors=vendorRepository.findAll();

        return Vendors.stream().map(Vendor ->mapToDto(Vendor)).collect(Collectors.toList());
    }

    @Override
    public VendorDto getVendorById(String id) {
        Vendor vendor=vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("vendor","id",id));
        return mapToDto(vendor);
    }

    @Override
    public VendorDto updateVendor(VendorDto vendorDto, String id) {
       Vendor vendor=vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("vendor","id",id));

       vendor.setName(vendorDto.getName());
       vendor.setUserName(vendorDto.getUserName());
       vendor.setPassword(vendorDto.getPassword());

       Vendor updatedvendor=vendorRepository.save(vendor);
        return mapToDto(updatedvendor);
    }


    @Override
    public void deleteVendorById(String id) {
        Vendor vendor=vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("vendor","id",id));

        vendorRepository.delete(vendor);
    }

    private VendorDto mapToDto(Vendor vendor) {
        VendorDto vendorDto = new VendorDto();
        vendorDto.setID(vendor.getId());
        vendorDto.setName(vendor.getName());
        vendorDto.setUserName(vendor.getUserName());
        vendorDto.setPassword(vendor.getPassword());
        return vendorDto;
    }

    //convert Dto to entity
    private Vendor mapToEntity(VendorDto vendorDto) {
        Vendor vendor = new Vendor();
        vendor.setId(vendorDto.getID());
        vendor.setName(vendorDto.getName());
        vendor.setUserName(vendorDto.getUserName());
        vendor.setPassword(vendorDto.getPassword());
        return vendor;
    }

}
