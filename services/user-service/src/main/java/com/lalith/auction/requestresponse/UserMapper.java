package com.lalith.auction.requestresponse;


import com.lalith.auction.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(UserRequest userRequest) {
        if(userRequest == null) {
            return null;
        }
        return User.builder()
                .id(userRequest.id())
                .password(userRequest.password())
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .phoneNumber(userRequest.phoneNumber())
                .email(userRequest.email())
                .address(userRequest.address())
                .build();
    }
    public UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress()
        );
    }
}
