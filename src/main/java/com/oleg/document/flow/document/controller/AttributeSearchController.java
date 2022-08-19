package com.oleg.document.flow.document.controller;

import com.oleg.document.flow.document.model.Order;
import com.oleg.document.flow.document.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class AttributeSearchController {
    private final OrderService orderService;

    @GetMapping("/order/search")
    public List<Order> getAll(
            @RequestParam(defaultValue = "", name = "parOfOrder") String parOfOrder,
            @RequestParam(defaultValue = "", name = "textOrder") String textOrder
    ) {
        return orderService.getPartOfOrder(parOfOrder, textOrder);
    }
}
