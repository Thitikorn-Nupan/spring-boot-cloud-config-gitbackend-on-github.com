package com.ttknpdev.client.entities;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("provider") // use it then you dont use @Value() annotation
public class Provider {
    // -> provider.domain
    private String domain;
    // -> provider.port
    private String port;

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
