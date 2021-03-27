package com.jumia.PhoneNumber.core.dto;

public class PhoneNumbersFetchingRequest {
    private String countryName = "";

    public PhoneNumbersFetchingRequest() {}

    public PhoneNumbersFetchingRequest(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
