package com.oleg.document.flow.document.controller;

import com.oleg.document.flow.document.dto.StatusDTO;
import com.oleg.document.flow.document.service.OrderService;
import com.oleg.document.flow.document.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class CycleController {
    private final StatusService statusService;

    private final OrderService orderService;

    @GetMapping("orders/status")
    public Set<String> getStatus(@RequestBody StatusDTO statusDTO) {
        return statusService.getAvailableStatus(statusDTO.getStatus());
    }

    @PutMapping("orders/{id}/status")
    public StatusDTO getAction(@RequestBody StatusDTO statusDTO, @PathVariable Integer id) {
        return orderService.changeStatus(statusDTO, id);
    }
}
