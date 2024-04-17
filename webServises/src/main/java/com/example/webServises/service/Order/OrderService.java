package com.example.webServises.service.Order;

import com.example.webServises.dto.ItemDto;
import com.example.webServises.dto.OrderDto;
import com.example.webServises.entity.Order;

import java.util.List;

public interface OrderService {
    OrderDto Create(OrderDto orderDto);
    List<OrderDto> getAll();
    OrderDto getById(String id);
    OrderDto update(OrderDto orderDto,String id);
    void deleteById(String id);
}
