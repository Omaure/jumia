package com.jumia.PhoneNumber.core.dto;

import com.jumia.PhoneNumber.core.models.Customer;

import java.util.List;

public class PhoneNumbersFetchingResponse {

    private List<Customer> customerPhonesList;

    public PhoneNumbersFetchingResponse() {}

    public PhoneNumbersFetchingResponse(List<Customer> customerPhonesList) {
        this.customerPhonesList = customerPhonesList;
    }

    public List<Customer> getCustomerPhonesList() {
        return customerPhonesList;
    }

    public void setCustomerPhonesList(List<Customer> customerPhonesList) {
        this.customerPhonesList = customerPhonesList;
    }
}
