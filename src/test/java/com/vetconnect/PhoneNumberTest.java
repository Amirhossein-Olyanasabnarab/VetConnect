package com.vetconnect;

import com.vetconnect.common.domain.valueObject.PhoneNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberTest {

    @Test
    void should_create_valid_number(){

        PhoneNumber phoneNumber = new PhoneNumber("09123099628");

        assertEquals(
                "+989123099628", phoneNumber.value()
        );
    }

    @Test
    void should_throw_exception_when_phone_number_is_invalid(){
        assertThrows(
                IllegalAccessException.class,
                () -> new PhoneNumber("124")
        );
    }

    @Test
    void should_throw_exception_when_phone_number_is_null() {
        assertThrows(
                NullPointerException.class,
                () -> new PhoneNumber(null)
        );
    }

    @Test
    void should_throw_exception_when_phone_number_is_blank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new PhoneNumber("     ")
        );
    }

}
