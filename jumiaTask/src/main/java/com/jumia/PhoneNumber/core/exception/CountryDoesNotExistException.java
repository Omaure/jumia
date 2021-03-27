package com.jumia.PhoneNumber.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryDoesNotExistException extends RuntimeException {

    private final Map<String, String> arguments = new HashMap<>();

    public CountryDoesNotExistException() {
        super();
    }

    public CountryDoesNotExistException(String field, String message) {
        super(message);
        arguments.put("field", field);
    }

    public CountryDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public Map<String, String> getArguments() {
        return arguments;
    }

}
