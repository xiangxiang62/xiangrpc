package com.xiang.example.consumer;

import com.xiang.example.common.model.User;
import com.xiang.example.common.service.UserService;
import com.xiang.xiangrpc.proxy.ServiceProxyFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("xx");
        User userName = userService.getUser(user);
        System.out.println(userName.getName());
    }



    /**
     * 静态代理调用
     * @param args
     */
//    public static void main(String[] args) {
//        UserService userService = new UserServiceProxy();
//        User user = new User();
//        user.setName("coderXiang");
//        User user1 = userService.getUser(user);
//        System.out.println(user1.getName);
//    }



//    public static void main(String[] args) {
//        // todo 需要获取 UserService 的实现类对象
//        UserService userService = null;
//        User user = new User();
//        user.setName("xiang");
//        // 调用
//        User newUser = userService.getUser(user);
//        if (newUser != null) {
//            System.out.println(newUser.getName());
//        } else {
//            System.out.println("user is null");
//        }
//    }
}
