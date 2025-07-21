package com.lalith.auction.requestresponse;


import com.lalith.auction.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserRequest(
        UUID id,
        @NotNull(message = "User first name is required")
        String firstName,
        @NotNull(message = "User first name is required")
        String lastName,
        @NotNull(message = "User Email is required")
        @Email
        String email,
        @NotNull(message = "User Password is required")
        String password,
        @NotNull(message = "user Phone Number is required")
        String phoneNumber,
        Address address

) {
}
