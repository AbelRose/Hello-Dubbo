package com.matrix.gmall;

import com.matrix.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
		OrderService orderService = ioc.getBean(OrderService.class);
		// 通过orderService会调userService -> userService会远程调用getUserAddressList
		orderService.initOrder("1");
		System.out.println("调用完成...");
		// 阻塞
		System.in.read();
	}
}
