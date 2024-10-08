package cibertec.edu.pe.T2_JV_JM.controller;

import cibertec.edu.pe.T2_JV_JM.dto.OrderDto;
import cibertec.edu.pe.T2_JV_JM.model.Order;
import cibertec.edu.pe.T2_JV_JM.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final IOrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto) {
        Order newOrder = orderService.createOrder(orderDto);
        return ResponseEntity.status(201).body(newOrder);
    }
}
