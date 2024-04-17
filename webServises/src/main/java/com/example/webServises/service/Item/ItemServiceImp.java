package com.example.webServises.service.Item;

import com.example.webServises.Controller.item.ItemResource;
import com.example.webServises.dto.CustomerDto;
import com.example.webServises.dto.ItemDto;
import com.example.webServises.dto.OrderDto;
import com.example.webServises.entity.Customer;
import com.example.webServises.entity.Item;
import com.example.webServises.entity.Order;
import com.example.webServises.entity.Vendor;
import com.example.webServises.exception.ResourceNotFoundException;
import com.example.webServises.reposirory.ItemRepository;
import com.example.webServises.reposirory.OrderRepository;
import com.example.webServises.reposirory.VendorReposetory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ItemServiceImp implements ItemService {

    private ItemRepository itemRepository;


    public ItemServiceImp(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }
    @Override
    public ItemDto Create(ItemDto orderDto) {
        Item order=mapToEntity(orderDto);
        Item newOrder=itemRepository.save(order);

        ItemDto orderREs=mapToDto(newOrder);

        return orderREs;
    }
//    public ItemDto Create(ItemDto itemDto) {
//        // Retrieve the order by its ID
////        Order order = orderRepository.findById(itemDto.getId())
////                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", itemDto.getId()));
////
////        // Retrieve the vendor by its ID
////        Vendor vendor = vendorReposetory.findById(itemDto.getId())
////                .orElseThrow(() -> new ResourceNotFoundException("Vendor", "id", itemDto.getId()));
////
////        // Create a new Item entity
//        Item item = mapToEntity(itemDto);
////
////        // Set the order and vendor for the item
////        item.setIdOrder(order);
////        item.setIdVendor(vendor);
//
//        // Save the item to the repository
//        Item newItem = itemRepository.save(item);
//
//        // Map the saved item back to a DTO
//        ItemDto itemResponse = mapToDto(newItem);
//
//        return itemResponse;
//    }


    @Override
    public List<ItemDto> getAll() {
        List<Item> items= itemRepository.findAll();

        return items.stream().map(item -> mapToDto(item)).collect(Collectors.toList());
    }

    @Override
    public ItemDto getById(String id) {
        Item item=itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("item","id",id));;

        return mapToDto(item);
    }

    @Override
    public ItemDto update(ItemDto itemDto, String id) {

        Item item=itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("item","id",id));;
        item.setId(itemDto.getId());
        item.setIdOrder(item.getIdOrder());
        item.setIdVendor(item.getIdVendor());
        item.setPrice(item.getPrice());
        Item newItem=itemRepository.save(item);

        return mapToDto(newItem);
    }

    @Override
    public void deleteById(String id) {

    }


    private ItemDto mapToDto(Item item) {
        ItemDto itemDto=new ItemDto();

        itemDto.setId(item.getId());
        itemDto.setIdOrder(item.getIdOrder());
        itemDto.setIdVendor(item.getIdVendor());
        itemDto.setPrice(item.getPrice());
        return itemDto;

    }

    private Item mapToEntity(ItemDto itemDto) {
        Item item=new Item();
        item.setId(itemDto.getId());
        item.setIdOrder(itemDto.getIdOrder());
        item.setIdVendor(itemDto.getIdVendor());
        item.setPrice(itemDto.getPrice());
        return item;
    }
}
