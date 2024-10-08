package cibertec.edu.pe.T2_JV_JM.controller;

import cibertec.edu.pe.T2_JV_JM.dto.OrderDetailDto;
import cibertec.edu.pe.T2_JV_JM.model.OrderDetail;
import cibertec.edu.pe.T2_JV_JM.service.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders_detail")
public class OrderDetailController {

    private final IOrderDetailService orderDetailService;


    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetailDto orderDetailDto) {
        OrderDetail newOrderDetail = orderDetailService.createOrderDetail(orderDetailDto);
        return ResponseEntity.status(201).body(newOrderDetail);
    }
}
