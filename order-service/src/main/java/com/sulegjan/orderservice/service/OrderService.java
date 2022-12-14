package com.sulegjan.orderservice.service;


import com.sulegjan.orderservice.dto.OrderLineItemsDto;
import com.sulegjan.orderservice.dto.OrderRequest;
import com.sulegjan.orderservice.model.Order;
import com.sulegjan.orderservice.model.OrderLineItems;
import com.sulegjan.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;


  public void placeOrder(OrderRequest orderRequest){
       Order order = new Order();
       order.setOrderNumber(UUID.randomUUID().toString());
      List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
              .stream()
              .map(this::mapToDto)
              .toList();
      order.setOrderLineItemsList(orderLineItems);
      orderRepository.save(order);
  }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
     OrderLineItems orderLineItems = new OrderLineItems();
     orderLineItems.setPrice(orderLineItemsDto.getPrice());
     orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
     orderLineItems.setBookName(orderLineItemsDto.getBookName());
     return orderLineItems;
    }
}
