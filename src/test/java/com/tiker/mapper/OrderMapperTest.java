package com.tiker.mapper;

import com.tiker.dao.DutyMapper;
import com.tiker.dao.OrderMapper;
import com.tiker.entity.bo.GetOrderBO;
import com.tiker.entity.bo.OrderBO;
import com.tiker.entity.dto.GetOrderDTO;
import com.tiker.entity.vo.ShowOrderVO;
import com.tiker.util.IDGenerator;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderMapperTest {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private DutyMapper dutyMapper;

    @Test
    public void testInsertOrder() {
        OrderBO order = new OrderBO();
        order.setId(IDGenerator.generateUUID(32));
        order.setPrice(34.6);
        order.setStatus(0);
        order.setRequester(IDGenerator.generateUUID(32));
        order.setDuty(IDGenerator.generateUUID(32));

        int insertResult = orderMapper.insertOrder(order);
        assertEquals(1, insertResult);
    }

    @Test
    public void testGetOrderListByFilter() throws ParseException {
        GetOrderBO getOrderBO1 = new GetOrderBO();
        getOrderBO1.setUniversity("nudt");
        getOrderBO1.setCampus("3haoyuan");
        List<ShowOrderVO> result1 = orderMapper.getOrderListByFilter(getOrderBO1);
        System.out.println(result1);
        assertEquals(1, result1.size());
        assertEquals(result1.get(0).getOrderId(), "c52f10b50d284df1aa59c211ea34993999b2917874ee4f0cad14cfdd4fb55f93");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GetOrderBO getOrderBO2 = new GetOrderBO();
        getOrderBO2.setDate(dateFormat.parse("2023-02-12"));
        List<ShowOrderVO> result2 = orderMapper.getOrderListByFilter(getOrderBO2);
        System.out.println(result2);
        assertEquals(1, result2.size());
        assertEquals(result2.get(0).getOrderId(), "c52f10b50d284df1aa59c211ea34993999b2917874ee4f0cad14cfdd4fb55f93");

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        GetOrderBO getOrderBO3 = new GetOrderBO();
        getOrderBO3.setDate(dateFormat.parse("2023-02-12"));
        getOrderBO3.setStartTime(timeFormat.parse("14:00:00"));
        getOrderBO3.setEndTime(timeFormat.parse("20:00:00"));
        List<ShowOrderVO> result3 = orderMapper.getOrderListByFilter(getOrderBO3);
        System.out.println(result3);
        assertEquals(1, result3.size());
        assertEquals(result3.get(0).getOrderId(), "c52f10b50d284df1aa59c211ea34993999b2917874ee4f0cad14cfdd4fb55f93");

        GetOrderBO getOrderBO4 = new GetOrderBO();
        getOrderBO4.setUniversity("nudt");
        getOrderBO4.setCampus("3haoyuan");
        getOrderBO4.setDate(dateFormat.parse("2023-02-12"));
        getOrderBO4.setStartTime(timeFormat.parse("14:00:00"));
        getOrderBO4.setEndTime(timeFormat.parse("20:00:00"));
        List<ShowOrderVO> result4 = orderMapper.getOrderListByFilter(getOrderBO4);
        System.out.println(result4);
        assertEquals(1, result4.size());
        assertEquals(result4.get(0).getOrderId(), "c52f10b50d284df1aa59c211ea34993999b2917874ee4f0cad14cfdd4fb55f93");
    }

    @Test
    public void testGetOrderById() {
        OrderBO result = orderMapper.getOrder("963ab9fc30204c228d12a74c2f5a75a501cc936ef56a4fa5ac8191f01328b45e", "86da5975f8ff4e82b3b03c501d76c622", null, 1);
        System.out.println(result);
        assertEquals(1, result.getStatus());
    }

    @Test
    public void testChangeOrderStatus() {
        OrderBO result = orderMapper.getOrder("963ab9fc30204c228d12a74c2f5a75a501cc936ef56a4fa5ac8191f01328b45e", "86da5975f8ff4e82b3b03c501d76c622", null, 1);
        System.out.println(result);
        assertEquals(1, result.getStatus());

        orderMapper.changeOrderStatus(result.getId(), 2, null);
        OrderBO result2 = orderMapper.getOrder("963ab9fc30204c228d12a74c2f5a75a501cc936ef56a4fa5ac8191f01328b45e", "86da5975f8ff4e82b3b03c501d76c622", null, 2);
        System.out.println(result2);
        assertEquals(2, result2.getStatus());

        orderMapper.changeOrderStatus(result.getId(), 1, null);
    }

//    @Test
//    public void testUpdateAcceptorAndStatus() {
//        String orderId = "aaa";
//        String acceptorId = "testAcceptorId";
//        int orderStatus = 2;
//
//        orderMapper.updateAcceptorAndStatus(orderId, acceptorId, orderStatus);
//    }
//
//    @Test
//    public void testUpdateStatus() {
//        String orderId = "aaa";
//        int orderStatus = 3;
//
//        orderMapper.updateStatus(orderId, orderStatus);
//    }
//
//    @Test
//    public void testQueryOrderListByUserIdAndStatus(){
//        String requestUserId = "abc";
//        List<ShowOrderVO> showOrderVOList = orderMapper.queryOrderListByUserIdAndStatus(requestUserId, null, 2);
//
//        assertEquals(showOrderVOList.size(), 1);
//
//        for (ShowOrderVO vo : showOrderVOList){
//            System.out.println(vo);
//        }
//    }
}
