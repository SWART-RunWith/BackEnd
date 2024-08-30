package com.swart.runwith.global.converter;

import com.swart.runwith.enums.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(final UserRole userRole) {
        if (userRole == null) {
            throw new NullPointerException("converter error : UserRole is null");
        }

        return userRole.toString();
    }

    @Override
    public UserRole convertToEntityAttribute(final String s) {
        return UserRole.valueOf(s);
    }
}
