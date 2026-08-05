package com.vetconnect.common.domain.valueObject;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.Objects;

public record PhoneNumber(String value) {

    private final static PhoneNumberUtil PHONE_NUMBER_UTIL =
            PhoneNumberUtil.getInstance();

    private static final String DEFAULT_REGION = "IR";

    public PhoneNumber {

        Objects.requireNonNull(value, "Phone number can not be null");

        String normalizePhoneNumber = value.trim();

        if (normalizePhoneNumber.isBlank())
            throw new IllegalArgumentException("Phone number can not be blank");

        try {

            var phoneNumber = PHONE_NUMBER_UTIL.parse(
                    normalizePhoneNumber, DEFAULT_REGION
            );

            if (!PHONE_NUMBER_UTIL.isValidNumber(phoneNumber))
                throw new IllegalArgumentException("Invalid phone number");

            value = PHONE_NUMBER_UTIL.format(
                    phoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164
            );

        } catch (NumberParseException exception) {
            throw new IllegalArgumentException("Invalid phone number", exception);
        }
    }
}
