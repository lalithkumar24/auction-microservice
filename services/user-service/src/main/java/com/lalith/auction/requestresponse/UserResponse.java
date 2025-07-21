package com.lalith.auction.requestresponse;

import com.lalith.auction.model.Address;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        Address address
) {
}
