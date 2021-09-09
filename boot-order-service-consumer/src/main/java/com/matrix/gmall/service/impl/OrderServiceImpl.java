package com.matrix.gmall.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.matrix.gmall.bean.UserAddress;
import com.matrix.gmall.service.OrderService;
import com.matrix.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 只写实现类就可以 接口在gmall-interface中 pom中导入gmall-interface
 *
 * Dubbo
 * 1. 将服务提供者注册到注册中心 (暴露服务)
 *    a. 导入Dubbo依赖 以及 操作zookeeper的客户端(curator)
 *    b. 配置服务的提供者
 * 2. 让服务消费者去注册中心订阅服务提供者的服务地址(服务提供者的机器 一个远程通信的连接)
 *
 * @Author yihaosun
 */
@Service
public class OrderServiceImpl implements OrderService {
    /**
     * 在没有使用RPC的情况下 是把这个UserService的接口拿过来
     * 是一种面向接口的思想
     * 注意
     * 1. 这次一定是失败的 因为接口的实现在别的服务里面
     * 2. 另外万一其他的服务也要调用这个接口的话 要在每个服务里面都加上 就会很冗余 -> 因此 要将这些接口放在同一个存放所有接口工程里面
     */

    /**
     * 在consumer.xml 中配置完成后就可以@Autowired 引用这个userService了
     * <dubbo:reference interface="com.matrix.gmall.service.UserService"
     *      id="userService" timeout="5000" retries="3" version="*">
     * </dubbo:reference>
     */

    /**
     * 以SpringBoot的方式的话不用@Autowired注解而是@Reference注解
     * 消费: 远程去引用这个UserService的服务
     */
//    @Autowired
//    可以用本地缓存连接远程服务
//    @Reference(url = "127.0.0.1:2088") // Dubbo直连 是绕过ZK的(当ZK宕机或者没有注册中心的时候)
//    @Reference(loadbalance="配置负载均衡的属性")
    @Reference
    UserService userService;

    @HystrixCommand(fallbackMethod = "hystrix")
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户Id" + userId);
        // 查询用户的收货地址
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        userAddressList.forEach(userAddress -> System.out.println(userAddress.getUserAddress()));
        return userAddressList;
    }

    /**
     * 出错的时候调用这个方法
     * @param userId userId
     * @return List<UserAddress>
     */
    public String hystrix(String userId) {
        return "Hystrix 出错了...";
    }
}
