package com.tiker.service.impl;

import com.tiker.dao.DutyMapper;
import com.tiker.dao.OrderMapper;
import com.tiker.entity.bo.DutyBO;
import com.tiker.entity.bo.GetOrderBO;
import com.tiker.entity.bo.OrderBO;
import com.tiker.entity.dto.CreateOrderDTO;
import com.tiker.entity.dto.GetOrderDTO;
import com.tiker.entity.vo.ShowOrderVO;
import com.tiker.enums.OrderStatusEnum;
import com.tiker.service.OrderService;
import com.tiker.util.IDGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    public static final int ORDER_ID_LENGTH = 64;
    public static final int DUTY_ID_LENGTH = 64;

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private DutyMapper dutyMapper;

    private SimpleDateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat timeFormat =  new SimpleDateFormat("HH:mm:ss");

    @Override
    public int createOrder(CreateOrderDTO createOrderDto) throws Exception {
        DutyBO duty = new DutyBO();
        String dutyId = IDGenerator.generateUUID(DUTY_ID_LENGTH);
        duty.setId(dutyId);
        BeanUtils.copyProperties(createOrderDto, duty);
        duty.setDate(dateFormat.parse(createOrderDto.getDate()));
        duty.setStartTime(timeFormat.parse(createOrderDto.getStartTime()));
        duty.setEndTime(timeFormat.parse(createOrderDto.getEndTime()));

        int dutyInsertResult = dutyMapper.insertDuty(duty);

        if (dutyInsertResult < 1) {
            throw new Exception("Create duty failed");
        }

        OrderBO order = new OrderBO();
        order.setId(IDGenerator.generateUUID(ORDER_ID_LENGTH));
        order.setStatus(OrderStatusEnum.NEW_ORDER.getStatusCode());
        BeanUtils.copyProperties(createOrderDto, order);
        order.setDuty(dutyId);

        int orderInsertResult = orderMapper.insertOrder(order);

        if (dutyInsertResult < 1) {
            throw new Exception("Create order failed");
        }

        return (orderInsertResult + dutyInsertResult) / 2;
    }

    @Override
    public List<ShowOrderVO> getOrderList(GetOrderDTO getOrderDto) throws ParseException {
        GetOrderBO getOrderBO = new GetOrderBO();
        getOrderBO.setDate(dateFormat.parse(getOrderDto.getDate()));
        getOrderBO.setStartTime(timeFormat.parse(getOrderDto.getStartTime()));
        getOrderBO.setEndTime(timeFormat.parse(getOrderDto.getEndTime()));
        BeanUtils.copyProperties(getOrderDto, getOrderBO);

        return orderMapper.getOrderListByFilter(getOrderBO);
    }

    @Override
    public int cancelOrder(String orderId, String requesterId) throws Exception {
        OrderBO toBeCanceledOrder = orderMapper.getOrder(orderId, requesterId, null, OrderStatusEnum.NEW_ORDER.getStatusCode());
        if (toBeCanceledOrder == null) {
            throw new Exception("Error: No such order");
        }

        return orderMapper.changeOrderStatus(orderId, OrderStatusEnum.CANCEL_ORDER.getStatusCode(), null);
    }

    @Override
    public int acceptOrder(String orderId, String recipientId) throws Exception {
        OrderBO toAcceptOrder = orderMapper.getOrder(orderId, null, null, OrderStatusEnum.NEW_ORDER.getStatusCode());
        if (toAcceptOrder == null) {
            throw new Exception("Error: No such order");
        }

        return orderMapper.changeOrderStatus(orderId, OrderStatusEnum.ACCEPTED_ORDER.getStatusCode(), recipientId);
    }

    @Override
    public int completeOrder(String orderId, String recipientId) throws Exception {
        OrderBO toCompleteOrder = orderMapper.getOrder(orderId, null, recipientId, OrderStatusEnum.ACCEPTED_ORDER.getStatusCode());
        if (toCompleteOrder == null) {
            throw new Exception("Error: No such order");
        }

        return orderMapper.changeOrderStatus(orderId, OrderStatusEnum.COMPlETE_ORDER.getStatusCode(), null);
    }


}