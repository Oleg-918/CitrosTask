package com.oleg.document.flow.document.controller;

import com.oleg.document.flow.document.dto.OrderDTO;
import com.oleg.document.flow.document.model.Order;
import com.oleg.document.flow.document.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Log4j2
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public OrderDTO create(@RequestBody @Valid OrderDTO orderDTO) {
        log.info("Старт постзапроса на Поручение!");
        return orderService.createNewOrder(orderDTO);
    }

    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable("id") Integer id) {
        orderService.deleteOrder(id);
    }

    @PutMapping("/order")
    public OrderDTO update(@RequestBody @Valid OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    @GetMapping("/order")
    public List<Order> getAll(
            @RequestParam(defaultValue = "0",name ="page") Integer page,
            @RequestParam(defaultValue = "2",name ="size") Integer size
    ) {
        return orderService.getAllOrder(page, size);
    }
}
