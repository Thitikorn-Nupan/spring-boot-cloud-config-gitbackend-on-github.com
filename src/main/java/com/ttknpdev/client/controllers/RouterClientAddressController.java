package com.ttknpdev.client.controllers;

import com.ttknpdev.client.entities.Address;
import com.ttknpdev.client.entities.Provider;
import com.ttknpdev.client.service.AddressServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/address")
public class RouterClientAddressController {

    private Provider provider;
    private AddressServiceResponse addressServiceResponse;


    @Value("${address.url}")
    private String addressUrl;

    @Autowired // inject my bean for access properties file
    public RouterClientAddressController(Provider provider , AddressServiceResponse addressServiceResponse) {
        this.provider = provider;
        this.addressServiceResponse =addressServiceResponse;
    }

    @GetMapping(value = "/domain") // access gitbackend-server.properties
    private ResponseEntity<String> retrieveDomainFromGitBackendServer() {
        return ResponseEntity
                .ok()
                .body(provider.getDomain());
    }

    @GetMapping(value = "/port") // access gitbackend-server.properties
    private ResponseEntity<String> retrievePortFromGitBackendServer() {
        return ResponseEntity
                .ok()
                .body(provider.getPort());
    }

    @GetMapping(value = "/url") // access application.properties
    private ResponseEntity<String> retrieveUrlFromGitBackendServer() {
        return ResponseEntity
                .ok()
                .body(addressUrl);
    }


    @GetMapping(value = "/reads")
    private ResponseEntity<List<Address>> retrieveAllAddressFromGitBackendServer() {
        List<Address> addresses = addressServiceResponse.reads(addressUrl+"/reads");
        return ResponseEntity
                .ok()
                .body(addresses);
    }

    @GetMapping(value = "/read/{id}")
    private ResponseEntity<Address> retrieveAddressFromGitBackendServer(@PathVariable Long id) {
        Address address = addressServiceResponse.read(addressUrl+"/read/"+id);
        return ResponseEntity
                .ok()
                .body(address);
    }


}
