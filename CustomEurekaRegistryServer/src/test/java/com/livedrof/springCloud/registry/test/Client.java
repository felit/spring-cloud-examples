package com.livedrof.springCloud.registry.test;

import com.netflix.appinfo.*;
import com.netflix.appinfo.providers.CloudInstanceConfigProvider;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import org.junit.Test;

import static com.netflix.appinfo.InstanceInfo.*;

public class Client {
    @Test
    public void test() {
//        InstanceInfo instanceInfo = Builder.newBuilder().setHostName("localhost").build();
        // Eureka实例配置
        MyDataCenterInstanceConfig eurekaInstanceConfig = new MyDataCenterInstanceConfig();
        ApplicationInfoManager manager = new ApplicationInfoManager(eurekaInstanceConfig);

        // 客户端配置
        EurekaClientConfig config = new DefaultEurekaClientConfig();
        DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
        EurekaClient client = new DiscoveryClient(manager, config, args);

    }


}
