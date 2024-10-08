package cibertec.edu.pe.T2_JV_JM.service.impl;

import cibertec.edu.pe.T2_JV_JM.dto.OrderDetailDto;
import cibertec.edu.pe.T2_JV_JM.dto.OrderDto;
import cibertec.edu.pe.T2_JV_JM.exception.ResourceNotFoundException;
import cibertec.edu.pe.T2_JV_JM.model.Customer;
import cibertec.edu.pe.T2_JV_JM.model.Order;
import cibertec.edu.pe.T2_JV_JM.repository.CustomerRepository;
import cibertec.edu.pe.T2_JV_JM.repository.OrderDetailRepository;
import cibertec.edu.pe.T2_JV_JM.repository.OrderRepository;
import cibertec.edu.pe.T2_JV_JM.service.IOrderDetailService;
import cibertec.edu.pe.T2_JV_JM.service.IOrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final IOrderDetailService iorderDetailService;

    @Transactional()
    @Override
    public Order createOrder(OrderDto orderDto) {
            Order order = new Order();
            Customer customer = new Customer();
            customer.setCustomerId(orderDto.getCustomerId()); // Asegúrate de que el método sea correcto
            order.setCustomer(customer);
            Order newOrder = orderRepository.save(order);
            for (OrderDetailDto orderDetailDto : orderDto.getOrderDetailDto()) {
                orderDetailDto.setOrderId(newOrder.getOrderId()); // Asegúrate de que este método esté correcto
                iorderDetailService.createOrderDetail(orderDetailDto); ;
            }

            return newOrder;
    }
}
