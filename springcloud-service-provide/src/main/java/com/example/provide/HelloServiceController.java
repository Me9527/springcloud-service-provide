package com.example.provide;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    DiscoveryClient discoveryClient;    //自动注入DiscoveryClinet

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String sayHello(){

//		ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();    //获得service实例
    	List<String> sname = discoveryClient.getServices();		//获得service实例
    	List<ServiceInstance> serviceInstance = discoveryClient.getInstances(sname.get(0)); 			
        logger.info("/hello , host:"+serviceInstance.get(0).getHost()+"/n"+"/service_id:"+serviceInstance.get(0).getServiceId());

        return "成功访问服务";
    }

}