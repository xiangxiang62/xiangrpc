package com.xiang.example.provider;

import com.xiang.example.common.service.UserService;
import com.xiang.xiangrpc.RpcApplication;
import com.xiang.xiangrpc.registry.LocalRegistry;
import com.xiang.xiangrpc.server.HttpServer;
import com.xiang.xiangrpc.server.VertxHttpServer;

import java.util.spi.LocaleNameProvider;

public class ProviderExample {

    public static void main(String[] args) {
        // RPC 初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPost());
    }

}
