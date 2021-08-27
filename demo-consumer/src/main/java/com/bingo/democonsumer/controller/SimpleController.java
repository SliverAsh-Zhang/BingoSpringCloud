package com.bingo.democonsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private EurekaClient eurekaClient;

    @Autowired
    public void setEurekaClient(EurekaClient eurekaClient){
        this.eurekaClient = eurekaClient;
    }

    @GetMapping("/test")
    public String serviceURL(){
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("DEMO-PROVIDER",false);
        return instanceInfo.getHomePageUrl();
    }
}
