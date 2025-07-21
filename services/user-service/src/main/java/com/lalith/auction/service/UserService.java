package com.lalith.auction.service;

import com.lalith.auction.exception.UserNotFoundException;
import com.lalith.auction.model.User;
import com.lalith.auction.reopsitory.UserRepository;
import com.lalith.auction.requestresponse.UserMapper;
import com.lalith.auction.requestresponse.UserRequest;
import com.lalith.auction.requestresponse.UserResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.reactor.ReactorProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final ReactorProperties reactorProperties;

    public UUID createUser(UserRequest userRequest) {
        var user = userRepository.save(mapper.toUser(userRequest));
        return user.getId();
    }

    public void updateUser(UserRequest userRequest) {
        var user = userRepository.findById(userRequest.id()).orElseThrow(
                () -> new UserNotFoundException(
                        format("User with id '%s' not found",userRequest.id())
                ));
        mergeUser(user,userRequest);
        userRepository.save(user);
    }

    private void mergeUser(User user, UserRequest userRequest) {
        if(StringUtils.isNotBlank(userRequest.firstName())){
            user.setFirstName(userRequest.firstName());
        }
        if(StringUtils.isNotBlank(userRequest.lastName())){
            user.setLastName(userRequest.lastName());
        }
        if(StringUtils.isNotBlank(userRequest.phoneNumber())){
            user.setPhoneNumber(userRequest.phoneNumber());
        }
        if(StringUtils.isNotBlank(userRequest.password())){
            user.setPassword(userRequest.password());
        }
        if(StringUtils.isNotBlank(userRequest.email())){
            user.setPhoneNumber(userRequest.email());
        }
        if(userRequest.address() != null) {
            user.setAddress(userRequest.address());
        }
    }

    public List<UserResponse> findAllUsers(){
        return userRepository.findAll().stream().map(mapper::toUserResponse).collect(Collectors.toList());
    }
    public boolean userExists(UUID id) {
        return userRepository.findById(id).isPresent();
    }
    public UserResponse findUserById(UUID id) {
        return userRepository.findById(id).map(mapper::toUserResponse).orElseThrow(
                () -> new UserNotFoundException(format("User with id '%s' not found", id)
                ));
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
