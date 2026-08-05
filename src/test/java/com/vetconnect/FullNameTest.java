package com.vetconnect;

import com.vetconnect.common.domain.valueObject.FullName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FullNameTest {
    @Test
    void should_create_valid_full_name() {

        FullName fullName =
                new FullName("Amir", "Olyanasab");

        assertEquals(
                "Amir Olyanasab",
                fullName.fullName()
        );
    }

    @Test
    void should_trim_names() {

        FullName fullName =
                new FullName(" Amir ", " Olyanasab ");

        assertEquals(
                "Amir",
                fullName.firstName()
        );

        assertEquals(
                "Olyanasab",
                fullName.lastName()
        );
    }

    @Test
    void should_throw_exception_when_first_name_is_blank() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new FullName("", "Olyanasab")
        );
    }

    @Test
    void should_throw_exception_when_last_name_is_null() {

        assertThrows(
                NullPointerException.class,
                () -> new FullName("Amir", null)
        );
    }
}
