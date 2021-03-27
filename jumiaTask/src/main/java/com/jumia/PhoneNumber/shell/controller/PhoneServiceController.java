package com.jumia.PhoneNumber.shell.controller;

import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingRequest;
import com.jumia.PhoneNumber.core.dto.PhoneNumbersFetchingResponse;
import com.jumia.PhoneNumber.shell.services.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/phones")
public class PhoneServiceController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @CrossOrigin
    @GetMapping("")
    public @ResponseBody
    PhoneNumbersFetchingResponse getPhoneNumbers(@RequestParam(required = false) String country) {
        return phoneNumberService.fetchPhones(new PhoneNumbersFetchingRequest(country));
    }

}
