package com.ttknpdev.client.service;

import com.ttknpdev.client.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AddressServiceResponse {
    private RestTemplate restTemplate;

    @Autowired
    public AddressServiceResponse(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Address> reads(String urlReads) {
        Address[] objects = restTemplate.getForObject(urlReads, Address[].class);
        List<Address> addresses = null;
        if (objects != null) {
            addresses = Arrays.asList(objects);
        }
        return addresses;
    }

    public Address read(String urlRead) {
        Address address = restTemplate.getForObject(urlRead, Address.class);
        return address;
    }
}
