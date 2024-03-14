package com.xiang.xiangrpc.proxy;

import com.xiang.xiangrpc.RpcApplication;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂（用于创建代理对象）
 */
public class ServiceProxyFactory {

    /**
     * 根据服务类获取对象
     *
     * @param serviceClass
     * @return
     * @param <T>
     */
    // 1. 指定接口类型：传入的 serviceClass 参数指定了要创建代理对象的接口类型。
    public static <T> T getProxy(Class<T> serviceClass) {

        if (RpcApplication.getRpcConfig().isMock()) {
            return getMockProxy(serviceClass);
        }
        // 使用 Proxy.newProxyInstance 创建代理对象：利用 Proxy.newProxyInstance 方法来创建代理对象，该方法接受三个参数：
        // ClassLoader 对象：用于加载代理类的类加载器，通常使用被代理接口的类加载器。
        // Class[] 对象数组：包含代理类要实现的接口列表，这里只包含了一个 serviceClass。
        // InvocationHandler 对象：定义了代理对象的行为，这里使用了 ServiceProxy 作为代理处理器。

        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy()
        );
    }

    public static <T> T getMockProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new MockServiceProxy()
        );
    }
}
