package com.xiang.example.consumer;

import com.xiang.xiangrpc.config.RpcConfig;
import com.xiang.xiangrpc.utils.ConfigUtils;

public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class,"rpc");
        System.out.println(rpc);
    }

}
