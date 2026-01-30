package com.lalith.auction.controller;

import com.lalith.auction.dto.UserRequest;
import com.lalith.auction.dto.UserResponse;
import com.lalith.auction.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    // ==============================
    // 1. Create User
    // ==============================
    @PostMapping
    public ResponseEntity<UUID> createUser(@RequestBody UserRequest request) {
        UUID userId = userService.createUser(request);
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    // ==============================
    // 2. Update User
    // ==============================
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable UUID userId,
            @RequestBody UserRequest request
    ) {
        return ResponseEntity.ok(userService.updateUser(request, userId));
    }

    // ==============================
    // 3. Get User By ID
    // ==============================
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    // ==============================
    // 4. Get User By Email
    // ==============================
    @GetMapping("/email")
    public ResponseEntity<UserResponse> getUserByEmail(
            @RequestParam String email
    ) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    // ==============================
    // 5. Get User By Phone Number
    // ==============================
    @GetMapping("/phone")
    public ResponseEntity<UserResponse> getUserByPhone(
            @RequestParam String phoneNumber
    ) {
        return ResponseEntity.ok(userService.getUserByPhoneNumber(phoneNumber));
    }

    // ==============================
    // 6. Delete User
    // ==============================
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    // ==============================
    // 7. Search Users (Pagination)
    // ==============================
    @GetMapping("/search")
    public ResponseEntity<List<UserResponse>> searchUsers(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(userService.searchForUsers(keyword, page, size));
    }
}
