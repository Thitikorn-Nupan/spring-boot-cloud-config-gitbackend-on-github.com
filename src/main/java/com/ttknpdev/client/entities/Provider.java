package com.ttknpdev.client.entities;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("provider") // use it then you dont use @Value() annotation
public class Provider {

    private String domain; // -> provider.domain
    private String port; // -> provider.port

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "domain='" + domain + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
