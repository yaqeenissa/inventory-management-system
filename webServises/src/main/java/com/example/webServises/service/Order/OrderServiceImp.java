package com.example.webServises.service.Order;

import com.example.webServises.dto.CustomerDto;
import com.example.webServises.dto.OrderDto;
import com.example.webServises.entity.Customer;
import com.example.webServises.entity.Order;
import com.example.webServises.exception.ResourceNotFoundException;
import com.example.webServises.reposirory.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderServiceImp implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public OrderDto Create(OrderDto orderDto) {
        Order order=mapToEntity(orderDto);
        Order newOrder=orderRepository.save(order);

        OrderDto orderREs=mapToDto(newOrder);

        return orderREs;
    }

    @Override
    public List<OrderDto> getAll() {
        List<Order> orders=orderRepository.findAll();

        return orders.stream().map(order -> mapToDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDto getById(String id) {
        Order order=orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order","id",id));
        return mapToDto(order);
    }

    @Override
    public OrderDto update(OrderDto orderDto, String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
    private OrderDto mapToDto(Order order) {
        OrderDto orderDto=new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setCustomerId(order.getCustomerId());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setItemId(order.getItemId());
        return orderDto;

    }
    private Order mapToEntity(OrderDto orderDto) {
        Order order=new Order();
        order.setId(orderDto.getId());
        order.setCustomerId(orderDto.getCustomerId());
        order.setItemId(orderDto.getItemId());
        order.setQuantity(orderDto.getQuantity());

        return order;
    }
}
