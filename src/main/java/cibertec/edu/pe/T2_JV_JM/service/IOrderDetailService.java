package cibertec.edu.pe.T2_JV_JM.service;

import cibertec.edu.pe.T2_JV_JM.dto.OrderDetailDto;
import cibertec.edu.pe.T2_JV_JM.model.OrderDetail;

public interface IOrderDetailService {

    OrderDetail createOrderDetail(OrderDetailDto orderDetailDto);
}
