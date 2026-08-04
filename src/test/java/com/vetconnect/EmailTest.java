package com.vetconnect;

import com.vetconnect.common.domain.valueObject.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void should_create_valid_email() {
        Email email = new Email("amirholya01@test.com");
        assertEquals("amirholya01@test.com", email.value());
    }

    @Test
    void should_throw_exception_when_email_is_invalid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Email("invalid-email")
        );
    }

    @Test
    void should_trim_and_lowercase_email() {
        Email email = new Email(" Amirholya01@Test.COM ");
        assertEquals("amirholya01@test.com", email.value());
    }

    @Test
    void should_throw_exception_when_email_is_null() {
        assertThrows(
                NullPointerException.class,
                () -> new Email(null)
        );
    }

    @Test
    void should_throw_exception_when_email_is_blank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Email("     ")
        );
    }
}
