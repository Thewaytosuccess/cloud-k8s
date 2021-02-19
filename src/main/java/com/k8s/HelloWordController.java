package com.k8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xhzy
 */
@RestController
public class HelloWordController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/")
    public String hello(){
        return "hello world by k8s!";
    }

    @GetMapping("/services")
    public List<String> getServices(){
        return client.getServices();
    }
}
