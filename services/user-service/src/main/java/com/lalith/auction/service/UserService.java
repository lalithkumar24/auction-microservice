package com.lalith.auction.service;

import com.lalith.auction.Entity.User;
import com.lalith.auction.dto.UserRequest;
import com.lalith.auction.dto.UserMapper;
import com.lalith.auction.dto.UserResponse;
import com.lalith.auction.exceptions.ResourceNotFoundException;
import com.lalith.auction.repository.UserRepository;
import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;
    public final UserMapper userMapper;
    // ==========================================
    // 1. Main CRUD Operations
    // ==========================================
    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream().map(userMapper::fromUser).toList();
    }
    public UUID createUser(UserRequest request){
        return userRepository.save(userMapper.toUser(request)).getId();
    }

    public UserResponse updateUser(UserRequest request,UUID userId){
        var user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id "+userId+" not found")
        );
        merger(user,request);
        return userMapper.fromUser(userRepository.save(user));
    }

    public void merger(User user, UserRequest request){
        user.setFirstName(request.firstName());
        user.setMiddleName(request.middleName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPhoneNumber(request.phoneNumber());
        user.setAddress(request.address());
    }

    public UserResponse getUserById(UUID id){
        var user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with id "+id+" not found")
        );
        return userMapper.fromUser(user);
    }
    public UserResponse getUserByEmail(String email){
        var user = userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("user with email " + email + " not found" )
        );
        return userMapper.fromUser(user);
    }
    public UserResponse getUserByPhoneNumber(String phoneNumber){
        var user = userRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new ResourceNotFoundException("user with phone number " + phoneNumber + " not found" )
        );
        return userMapper.fromUser(user);
    }
    public void deleteUser(UUID id){
        var user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User with id "+id+" not found")
        );
        userRepository.delete(user);
    }

    // ==========================================
    // 2. Search & Filters
    // ==========================================

    public List<UserResponse> searchForUsers(String keyword,int page,int size ){
        return userRepository.searchUsers(keyword, PageRequest.of(page,size)).stream().map(userMapper::fromUser).toList();
    }

}
