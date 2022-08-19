package com.oleg.document.flow.document.service;

import com.oleg.document.flow.document.dto.OrderDTO;
import com.oleg.document.flow.document.dto.StatusDTO;
import com.oleg.document.flow.document.model.Order;
import com.oleg.document.flow.document.repository.OrderRepository;
import com.oleg.document.flow.document.util.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final EntityManager entityManager;

    private final StatusService statusService;


    public OrderDTO createNewOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.save(order);
        return orderMapper.toOrderDTO(order);
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toOrder(orderDTO);
        orderRepository.save(order);
        return orderMapper.toOrderDTO(order);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public List<OrderDTO> getAllOrder(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findAll(pageable).getContent().stream()//возвращал Order а не OrderDTO
                .map(orderMapper::toOrderDTO)
                .collect(Collectors.toList());
    }


    public StatusDTO changeStatus(StatusDTO statusDTO, Integer id) {
        Order order = orderRepository.getReferenceById(id);
        if (statusService.getAvailableStatus(order.getStatus()).contains(statusDTO.getStatus())) {
            order.setStatus(statusDTO.getStatus());
            orderRepository.save(order);
            return new StatusDTO(order.getStatus());
        }
        throw new IllegalArgumentException("Данный статус не доступен!");
    }

    public List<Order> getPartOfOrder(String parOfOrder, String text) {
        log.error("AXAXAXAXAX");
        entityManager.createNativeQuery("SELECT * FROM orders WHERE ? LIKE CONCAT(''++'')")
        return typedQuery.getResultList();
    }

}

