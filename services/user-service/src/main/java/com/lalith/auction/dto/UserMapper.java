package com.lalith.auction.dto;


import com.lalith.auction.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(UserRequest request){
        if(request == null){
            return null;
        }
        return User.builder()
                .id(request.userId())
                .firstName(request.firstName())
                .middleName(request.middleName())
                .lastName(request.lastName())
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .address(request.address())
                .country(request.country())
                .state(request.state())
                .city(request.city())
                .pinCode(request.pinCode())
                .build();
    }

    public UserResponse fromUser(User user){
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress(),
                user.getItemsSold(),
                user.getItemsBought(),
                user.getWalletBalance(),
                user.getTotalRewards(),
                user.getLastActiveAt()
        );
    }
}
