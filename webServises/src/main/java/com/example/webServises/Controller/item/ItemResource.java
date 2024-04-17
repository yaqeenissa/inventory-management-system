package com.example.webServises.Controller.item;

import com.example.webServises.Controller.customer.CustomerResource;
import com.example.webServises.dto.ItemDto;
import com.example.webServises.dto.VendorDto;
import com.example.webServises.entity.Order;
import com.example.webServises.entity.Vendor;
import com.example.webServises.exception.ResourceNotFoundException;
import com.example.webServises.service.Item.ItemService;
import com.example.webServises.service.Item.ItemServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Item")
public class ItemResource {
    ItemServiceImp itemServiceImp;
    private final Logger log = LoggerFactory.getLogger(ItemResource.class);

    public ItemResource(ItemServiceImp itemServiceImp){
        this.itemServiceImp=itemServiceImp;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> getAllitems(){
        return ResponseEntity.ok().body(itemServiceImp.getAll());
    }
    @GetMapping
    public ItemDto getItemById(@RequestParam String id){
        return itemServiceImp.getById(id);
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@Valid @RequestBody ItemDto itemDto){

        return new ResponseEntity<>(itemServiceImp.Create(itemDto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> update(
            @Valid @RequestBody ItemDto vendorDto,
            @PathVariable(name="id") String id) {
        ItemDto updatedVendorDto = itemServiceImp.update(vendorDto, id);
        return new ResponseEntity<>( updatedVendorDto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name="id") String id) {
        itemServiceImp.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
