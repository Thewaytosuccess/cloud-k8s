package com.k8s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author xhzy
 */
@Configuration
public class K8sConfiguration {

    @Value("${hello:null}")
    private String hello;

    @Value("${config:null}")
    private String config;

    public void setConfig(String config) {
        this.config = config;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getConfig() {
        return config;
    }

    public String getHello() {
        return hello;
    }
}
