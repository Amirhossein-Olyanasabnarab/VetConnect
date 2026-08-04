package com.vetconnect.common.domain.valueObject;

import java.util.Objects;
import java.util.regex.Pattern;

public record Email(String value) {

    private final static Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public Email {
        Objects.requireNonNull(value, "Email can not be null");

        String normalizedEmail = value.trim().toLowerCase();

        if (normalizedEmail.isBlank())
            throw new IllegalArgumentException("Email can not be blank");

        if (!EMAIL_PATTERN.matcher(normalizedEmail).matches())
            throw new IllegalArgumentException("Invalid email format");

        value = normalizedEmail;
    }
}
