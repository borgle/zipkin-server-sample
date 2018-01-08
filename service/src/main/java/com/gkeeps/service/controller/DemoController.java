package com.gkeeps.service.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DemoController {

    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    EurekaClient client;

    @RequestMapping("/test")
    public String test() {
        InstanceInfo instance = client.getApplicationInfoManager().getInfo();
        return String.format("[%s] serviceId = %s, host = %s, port = %s",
                sdf.format(new Date()), instance.getAppName(), instance.getHostName(), instance.getPort());
    }
}
