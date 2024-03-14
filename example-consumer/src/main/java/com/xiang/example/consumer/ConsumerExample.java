package com.xiang.example.consumer;

import com.xiang.example.common.model.User;
import com.xiang.example.common.service.UserService;
import com.xiang.xiangrpc.config.RpcConfig;
import com.xiang.xiangrpc.proxy.ServiceProxyFactory;
import com.xiang.xiangrpc.utils.ConfigUtils;

public class ConsumerExample {

    public static void main(String[] args) {
        // 获取代理
        UserService UserService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("coderXiang");
        // 调用
        User newUser = UserService.getUser(user);
        if (newUser != null){
            System.out.println(newUser.getName());
        } else {
            System.out.println("user is null");
        }
        long number = UserService.getNumber();
        System.out.println(number);
        System.out.println("==============================");
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class,"rpc");
        System.out.println(rpc);
    }

}
