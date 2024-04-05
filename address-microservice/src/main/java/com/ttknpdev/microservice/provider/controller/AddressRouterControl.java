package com.ttknpdev.microservice.provider.controller;

import com.ttknpdev.microservice.provider.entity.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressRouterControl {

    @GetMapping(value = "/reads")
    private List<Address> retrieveAllAddresses () {
        return List.of(new Address(1L,"Suanluang","Bangkok","10250","1830 1832 Patanakarn Road"),new Address(2L,"Phayathai","Bangkok","10400","718/27-29 Soi Phayanark"));
    }

    @GetMapping(value = "/read/{id}")
    private Address retrieveAddress (@PathVariable Long id) {
        return new Address(id,"Suanluang","Bangkok","10250","1830 1832 Patanakarn Road");
    }

    @PostMapping(value = "/create")
    private Address addAddress (@RequestBody Address address) {
        Address newAddress = new Address(100L,address.getCity(),address.getProvince(),address.getCity(),address.getDetails());
        return newAddress;
    }

}
