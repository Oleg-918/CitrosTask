package com.oleg.document.flow.document.service;

import com.oleg.document.flow.document.dto.OrderDTO;
import com.oleg.document.flow.document.dto.StatusDTO;
import com.oleg.document.flow.document.model.Order;
import com.oleg.document.flow.document.repository.OrderRepository;
import com.oleg.document.flow.document.util.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    public OrderDTO createNewOrder(OrderDTO orderDTO){
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.save(order);
        return orderMapper.toOrderDTO(order);
    }

    public OrderDTO updateOrder(OrderDTO orderDTO){
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.save(order);
        return orderMapper.toOrderDTO(order);
    }

    public void deleteOrder(Integer id){
        orderRepository.deleteById(id);
    }

    public List<Order> getAllOrder(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findAll(pageable).getContent();
    }


    public StatusDTO changeStatus(StatusDTO statusDTO, Integer id) {
        Order order = orderRepository.getReferenceById(id);
        order.setStatus(statusDTO.getStatus());
        orderRepository.save(order);
        return new StatusDTO(order.getStatus());

    }


}

