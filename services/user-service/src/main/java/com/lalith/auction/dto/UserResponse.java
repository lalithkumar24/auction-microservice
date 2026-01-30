package com.lalith.auction.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse(
        UUID userId,
        String firstName,
        String lastName,
        String email,
        String address,
        int itemsSold,
        int itemsBought,
        double walletBalance,
        long totalRewards,
        LocalDateTime lastActiveAt

) {
}
