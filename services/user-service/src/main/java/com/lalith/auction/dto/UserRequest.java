package com.lalith.auction.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserRequest(
        UUID userId,
        @NotNull(message = "First Name cannot be null")
        String firstName,
        String middleName,
        @NotNull(message = "Last Name cannot be null")
        String lastName,
        @Email
        @NotNull(message = "Email cannot be null")
        String email,
        @NotNull(message = "phone number cant be null")
        String phoneNumber,
        @NotNull(message = "Address cant be null")
        String address,
        @NotNull(message = "Country cant be null")
        String country,
        @NotNull(message = "State cant be null")
        String state,
        @NotNull(message = "City cant be null")
        String city,
        @NotNull(message = "pincode cant be null")
        String pinCode

) {
}
