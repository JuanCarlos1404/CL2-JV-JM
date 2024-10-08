package cibertec.edu.pe.T2_JV_JM.service.impl;

import cibertec.edu.pe.T2_JV_JM.dto.OrderDetailDto;
import cibertec.edu.pe.T2_JV_JM.model.OrderDetail;
import cibertec.edu.pe.T2_JV_JM.model.pk.ProductOrderId;
import cibertec.edu.pe.T2_JV_JM.repository.OrderDetailRepository;
import cibertec.edu.pe.T2_JV_JM.service.IOrderDetailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@RequiredArgsConstructor
@Service
public class OrderDetailService implements IOrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    @Transactional
    @Override
    public OrderDetail createOrderDetail(OrderDetailDto orderDetailDto) {
        ProductOrderId productOrderId = new ProductOrderId();
        productOrderId.setBookId(orderDetailDto.getBookId());
        productOrderId.setOrderId(orderDetailDto.getOrderId());
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(productOrderId);
        orderDetail.setQuantity(orderDetailDto.getQuantity());
        return orderDetailRepository.save(orderDetail);
    }
}
