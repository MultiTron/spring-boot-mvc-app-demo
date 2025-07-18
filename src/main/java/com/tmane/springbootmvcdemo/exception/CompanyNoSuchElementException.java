package com.tmane.springbootmvcdemo.exception;


import lombok.Getter;

import java.util.NoSuchElementException;
import java.util.UUID;

@Getter
public class CompanyNoSuchElementException extends NoSuchElementException {
    private final UUID id;

    public CompanyNoSuchElementException(String message, UUID id) {
        super(message);
        this.id = id;
    }

}
