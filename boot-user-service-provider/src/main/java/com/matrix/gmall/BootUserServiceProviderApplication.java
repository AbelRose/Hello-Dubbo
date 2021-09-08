package com.matrix.gmall;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * SpringBoot的方式使用Dubbo
 * 1. 导入依赖
 *      a. 导入Dubbo-Starter
 *      b. 导入Dubbo的其他依赖
 * 2. 用Dubbo的@Service暴露注解
 *    添加@EnableDubbo 开启基于注解的dubbo功能
 *
 * SpringBoot与Dubbo整合的三种方式
 * 1. 导入Dubbo Starter 在application.properties中配置属性 使用@Service【暴露服务】 使用@Reference标签引用服务 并开启@EnableDubbo
 * 2. 导入Dubbo Starter
 *    将 provider.xml 放在resource文件夹下面 并注释掉application.properties文件(这两个只能存在一个) 去掉@EnableDubbo 引用 @ImportResource()
 *    @ImportResource(locations = "classpath:provider.xml") classpath 是包路径
 *    实现类中的暴露@Service注解也可以不用了
 * 3. 使用注解API的方式: 写一个配置类 将每个组件手动创建到容器里面
 */
@EnableDubbo
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
