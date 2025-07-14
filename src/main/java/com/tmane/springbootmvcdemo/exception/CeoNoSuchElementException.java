package com.tmane.springbootmvcdemo.exception;

import lombok.Getter;

import java.util.NoSuchElementException;
import java.util.UUID;

@Getter
public class CeoNoSuchElementException extends NoSuchElementException {
    private final UUID id;

    public CeoNoSuchElementException(String message, UUID id) {
        super(message);
        this.id = id;
    }
}
