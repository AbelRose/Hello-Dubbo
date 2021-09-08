package com.matrix.gmall.controller;

import com.matrix.gmall.bean.UserAddress;
import com.matrix.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    // 以Json的方式返回
    @ResponseBody
    @RequestMapping("initOrder")
    public List<UserAddress> initOrder(@RequestParam("uid") String userId) {
        return orderService.initOrder(userId);
    }
}
