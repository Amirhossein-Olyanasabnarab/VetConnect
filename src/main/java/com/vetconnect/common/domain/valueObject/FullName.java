package com.vetconnect.common.domain.valueObject;

import java.util.Objects;

public record FullName(String firstName, String lastName) {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 50;

    public FullName{

        Objects.requireNonNull(firstName, "First name can not be null");
        Objects.requireNonNull(firstName, "Last name can not be null");

        firstName = normalize(firstName);
        lastName = normalize(lastName);

        validate(firstName, "First name");
        validate(lastName, "Last name");

    }

    private static String normalize(String value){
        return value.trim();
    }

    private static void validate(String value, String fieldName){

        if (value.isBlank())
            throw new IllegalArgumentException(fieldName + " can nor be blank");

        if (value.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(fieldName + " is too short");
        }

        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(fieldName + " is too long");
        }
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
