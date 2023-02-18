package com.tiker.service;

import com.tiker.entity.dto.CreateOrderDTO;
import com.tiker.entity.dto.GetOrderDTO;
import com.tiker.entity.vo.ShowOrderVO;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

public interface OrderService {
    int createOrder(CreateOrderDTO createOrderDto) throws Exception;
    List<ShowOrderVO> getOrderList(GetOrderDTO getOrderDto) throws ParseException;

    int cancelOrder(String orderId, String requesterId) throws Exception;

    int acceptOrder(String orderId, String recipientId) throws Exception;

    int completeOrder(String orderId, String recipientId) throws Exception;

    int giveUpOrder(String orderId, String recipientId) throws Exception;

    int finishOrder(String orderId, String requesterId) throws Exception;
}
