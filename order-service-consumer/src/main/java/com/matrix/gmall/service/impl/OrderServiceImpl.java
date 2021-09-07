package com.matrix.gmall.service.impl;

import com.matrix.gmall.bean.UserAddress;
import com.matrix.gmall.service.OrderService;
import com.matrix.gmall.service.UserService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    /**
     * 在没有使用RPC的情况下 是把这个UserService的接口拿过来
     * 是一种面向接口的思想
     * 注意
     * 1. 这次一定是失败的 因为接口的实现在别的服务里面
     * 2. 另外万一其他的服务也要调用这个接口的话 要在每个服务里面都加上 就会很冗余 -> 因此 要将这些接口放在同一个存放所有接口工程里面
     */
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        // 查询用户的收货地址
        return userService.getUserAddressList(userId);
    }
}
