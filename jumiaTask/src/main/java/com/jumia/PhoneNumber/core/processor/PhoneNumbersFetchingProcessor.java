package com.jumia.PhoneNumber.core.processor;

import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingRequest;
import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingResponse;
import com.jumia.PhoneNumber.core.models.Customer;
import com.jumia.PhoneNumber.core.repo.PhoneNumberRepo;
import com.jumia.PhoneNumber.core.validator.CountryShouldExist;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumbersFetchingProcessor extends BaseProcessor<PhoneNumbersFetchingResponse> {

    private static final HashMap<String, String> countryCodes;

    static {
        countryCodes = new HashMap<>();
        countryCodes.put("Cameroon", "\\(237\\) ?[2368]\\d{7,8}$");
        countryCodes.put("Ethiopia", "\\(251\\) ?[1-59]\\d{8}$");
        countryCodes.put("Morocco", "\\(212\\) ?[5-9]\\d{8}$");
        countryCodes.put("Mozambique", "\\(258\\) ?[28]\\d{7,8}$");
        countryCodes.put("Uganda", "\\(256\\) ?\\d{9}$");
    }

    private final PhoneNumbersFetchingRequest request;
    private final PhoneNumberRepo phoneNumberRepo;

    public PhoneNumbersFetchingProcessor(PhoneNumbersFetchingRequest phoneNumbersFetchingRequest,
                                         PhoneNumberRepo phoneNumberRepo) {
        this.request = phoneNumbersFetchingRequest;
        this.phoneNumberRepo = phoneNumberRepo;
    }

    @Override
    void validate() {
        if (request.getCountryName() != null) {
            new CountryShouldExist(request.getCountryName(), countryCodes).orThrow();
        }
    }

    @Override
    PhoneNumbersFetchingResponse process() {
        List<Customer> result;
        result = getCustomers();
        return new PhoneNumbersFetchingResponse(result);
    }

    private List<Customer> getCustomers() {
        List<Customer> result;
        if (request.getCountryName() == null) {
            result = phoneNumberRepo.findAll();
        } else {
            result = getCustomersInCountry();
        }
        return result;
    }

    private List<Customer> getCustomersInCountry() {
        String regex = countryCodes.get(request.getCountryName());

        return phoneNumberRepo.findAll()
                .stream()
                .filter(customer -> customer.getPhone().matches(regex))
                .collect(Collectors.toList());
    }
}
