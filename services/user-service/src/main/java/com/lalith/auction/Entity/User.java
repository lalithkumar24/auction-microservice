package com.lalith.auction.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @Column(name = "password", nullable = false,length = 255)
    private String password;


    // --- Statistics ---
    @Column(name="items_soled")
    private int itemsSold = 0;
    @Column(name="items_bought")
    private int itemsBought = 0;
    @Column(name="total_rewarded")
    private int totalRewards = 0;
    @Column(name = "wallet_balance")
    private double walletBalance = 0.0;


    // --- Address ---

    private String address;
    private String country;
    private String state;
    private String city;
    @Column(name = "pin_code")
    private String pinCode;
    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    // --- Profile Fields ---

    @Column(name="profile_pic_url")
    private String profilePicUrl;
    @Column(name="is_verified")
    protected boolean isVerified = false;
    @Column(name="is_admin")
    protected boolean isAdmin = false;

    // --- Time Stamps---

    @CreationTimestamp
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(name = "last_modified")
    private LocalDateTime lastModified;
    @Column(name = "last_active_at")
    private LocalDateTime lastActiveAt;

}
