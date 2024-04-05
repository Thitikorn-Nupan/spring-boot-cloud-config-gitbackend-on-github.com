package com.ttknpdev.client.entities;

public class Address {
    private Long aid;
    private String city;
    private String province;
    private String zipcode;
    private String details;

    public Address(Long aid, String city, String province, String zipcode, String details) {
        this.aid = aid;
        this.city = city;
        this.province = province;
        this.zipcode = zipcode;
        this.details = details;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Address{" +
                "aid=" + aid +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}