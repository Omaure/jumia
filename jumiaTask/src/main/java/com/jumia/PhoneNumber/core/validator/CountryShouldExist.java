package com.jumia.PhoneNumber.core.validator;

import com.jumia.PhoneNumber.core.exception.CountryDoesNotExistException;

import java.util.HashMap;

public class CountryShouldExist <String> implements BaseValidator {

    private final String value;
    private final HashMap<String,String> countryCodes;

    public CountryShouldExist(String value, HashMap<String,String> countryCodes) {
        this.value = value;
        this.countryCodes = countryCodes;
    }

    @Override
    public void orThrow() throws CountryDoesNotExistException {
        if(!countryCodes.containsKey(value)){
            throw new CountryDoesNotExistException("country","The Requested Country Does not Exist");
        }
    }
}
