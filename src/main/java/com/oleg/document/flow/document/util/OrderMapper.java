package com.oleg.document.flow.document.util;

import com.oleg.document.flow.document.dto.OrderDTO;
import com.oleg.document.flow.document.model.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO orderDTO);
}
