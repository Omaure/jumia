package com.jumia.PhoneNumber.core.processor;

abstract class BaseProcessor<T> {
    abstract void validate();

    abstract T process();

    public T execute() {
        validate();
        return process();
    }
}
