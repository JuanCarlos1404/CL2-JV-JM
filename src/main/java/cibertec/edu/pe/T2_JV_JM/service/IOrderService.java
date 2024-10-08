package cibertec.edu.pe.T2_JV_JM.service;

import cibertec.edu.pe.T2_JV_JM.dto.OrderDto;
import cibertec.edu.pe.T2_JV_JM.model.Order;

import java.util.List;

public interface IOrderService {
    Order createOrder(OrderDto orderDto);
}
