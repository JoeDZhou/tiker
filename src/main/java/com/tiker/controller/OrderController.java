package com.tiker.controller;

import com.tiker.entity.dto.CreateOrderDTO;
import com.tiker.entity.dto.GetOrderDTO;
import com.tiker.entity.dto.RestResultDTO;
import com.tiker.entity.vo.ShowOrderVO;
import com.tiker.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/createOrder")
    public RestResultDTO createOrder(@RequestBody CreateOrderDTO createOrderDto) throws Exception {
        int createResult = orderService.createOrder(createOrderDto);
        if (createResult > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Create order err", null);
        }
    }

    @GetMapping("/filterOrderList")
    public RestResultDTO filterOrderList(@RequestBody GetOrderDTO getOrderDto) throws ParseException {
        List<ShowOrderVO> orders =  orderService.getOrderList(getOrderDto);
        return new RestResultDTO(0, "Success", orders);
    }

    @PostMapping("/cancelOrder")
    public RestResultDTO cancelOrder(@RequestParam("orderId") String orderId, @RequestParam("requesterId") String requesterId) throws Exception {
        int cancelNum = orderService.cancelOrder(orderId, requesterId);
        if (cancelNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Cancel order error: No such order", null);
        }
    }

    @PostMapping("/acceptOrder")
    public RestResultDTO acceptOrder(@RequestParam("orderId") String orderId, @RequestParam("recipientId") String recipientId) throws Exception {
        int acceptNum = orderService.acceptOrder(orderId, recipientId);
        if (acceptNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Accept order error: No such order", null);
        }
    }

    @PostMapping("/completeOrder")
    public RestResultDTO completeOrder(@RequestParam("orderId") String orderId, @RequestParam("recipientId") String recipientId) throws Exception {
        int completeNum = orderService.completeOrder(orderId, recipientId);
        if (completeNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Complete order error: No such order", null);
        }
    }

    @PostMapping("/giveUpOrder")
    public RestResultDTO giveUpOrder(@RequestParam("orderId") String orderId, @RequestParam("recipientId") String recipientId) throws Exception {
        int giveUpNum = orderService.giveUpOrder(orderId, recipientId);
        if (giveUpNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Give up order error: No such order", null);
        }
    }

    @PostMapping("/finishOrder")
    public RestResultDTO finishOrder(@RequestParam("orderId") String orderId, @RequestParam("requesterId") String requesterId) throws Exception {
        int finishNum = orderService.finishOrder(orderId, requesterId);
        if (finishNum > 0) {
            return new RestResultDTO(0, "Success", null);
        } else {
            return new RestResultDTO(1, "Finish order error: No such order", null);
        }
    }
}
