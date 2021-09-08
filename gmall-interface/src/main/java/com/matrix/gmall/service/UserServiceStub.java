package com.matrix.gmall.service;

import com.matrix.gmall.bean.UserAddress;

import java.util.List;

/**
 * 本地存根 用于本地校验参数等
 */
public class UserServiceStub implements UserService {
    private final UserService userService;

    /**
     * 创建一个有参构造器 这样Dubbo会自动传入UserService的远程代理对象
     * @param userService 远程代理对象
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("本地存根调用了...");
        // 对参数等进行检验
//        if(!StringUtils.isEmpty(userId)) {
        if(!userId.equals(null)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
