package com.tiker.dao;

import com.tiker.entity.bo.GetOrderBO;
import com.tiker.entity.bo.OrderBO;
import com.tiker.entity.dto.GetOrderDTO;
import com.tiker.entity.vo.ShowOrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int insertOrder(OrderBO order);

    List<ShowOrderVO> getOrderListByFilter(GetOrderBO getOrderBO);

    OrderBO getOrder(@Param("id") String id, @Param("requester") String requester, @Param("recipient") String recipient, @Param("status") int status);

    int changeOrderStatus(@Param("id") String id, @Param("status") int status, @Param("recipient") String recipient);

    List<ShowOrderVO> getOrderByUserAndStatus(@Param("requester") String requester, @Param("recipient") String recipient, @Param("status") int status);
}
