package com.jumia.PhoneNumber.shell.services;

import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingRequest;
import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingResponse;
import com.jumia.PhoneNumber.core.processor.PhoneNumbersFetchingProcessor;
import com.jumia.PhoneNumber.core.repo.PhoneNumberRepo;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberService {

    private final PhoneNumberRepo phoneNumberRepo;

    public PhoneNumberService(PhoneNumberRepo phoneNumberRepo) {
        this.phoneNumberRepo = phoneNumberRepo;
    }

    public PhoneNumbersFetchingResponse fetchPhones(PhoneNumbersFetchingRequest phoneNumbersFetchingRequest) {
        return new PhoneNumbersFetchingProcessor(phoneNumbersFetchingRequest, phoneNumberRepo).execute();
    }

}
