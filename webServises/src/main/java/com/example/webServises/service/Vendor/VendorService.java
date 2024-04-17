package com.example.webServises.service.Vendor;

import com.example.webServises.dto.CustomerDto;
import com.example.webServises.dto.VendorDto;

import java.util.List;

public interface VendorService {
    VendorDto CreateVendor(VendorDto vendorDto);

    List<VendorDto> getAllVendor();
    VendorDto getVendorById(String id);
    VendorDto updateVendor(VendorDto vendorDto,String id);
    void deleteVendorById(String id);

}
