package com.lalith.auction.controller;


import com.lalith.auction.requestresponse.UserRequest;
import com.lalith.auction.requestresponse.UserResponse;
import com.lalith.auction.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UUID> createUser(
            @RequestBody @Valid UserRequest userRequest
    ) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(
            @RequestBody @Valid UserRequest userRequest
    ){
        userService.updateUser(userRequest);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/exits/{user-id}")
    public ResponseEntity<Boolean> exits(@PathVariable("user-id") UUID userId) {
        return ResponseEntity.ok(userService.userExists(userId));
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable("user-id") UUID userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("user-id") UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
