package com.vetconnect.common.domain.entity;

import com.vetconnect.common.domain.valueObject.Email;
import com.vetconnect.common.domain.valueObject.FullName;
import com.vetconnect.common.domain.valueObject.PhoneNumber;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    private FullName fullName;
    private Email email;
    private PhoneNumber phoneNumber;

    private User(UUID id, FullName fullName, Email email, PhoneNumber phoneNumber) {
        super(id);
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
