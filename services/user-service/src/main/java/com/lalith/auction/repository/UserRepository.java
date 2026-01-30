package com.lalith.auction.repository;

import com.lalith.auction.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    // ==========================================
    // 1. AUTHENTICATION & VALIDATION
    // ==========================================


    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmailAndIsVerifiedTrue(String email);


    // ==========================================
    // 2. LEADERBOARDS (Auction Special)
    // ==========================================

    @Query("SELECT u FROM User u ORDER BY u.itemsSold DESC")
    List<User> findTopSellers(Pageable pageable);

    @Query("SELECT u FROM User u ORDER BY u.itemsBought DESC")
    List<User> findTopBuyers(Pageable pageable);

    @Query("SELECT u FROM User u ORDER BY u.walletBalance DESC")
    List<User> findRichestUsers(Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.isVerified = true ORDER BY u.itemsSold DESC")
    List<User> findTopVerifiedSellers(Pageable pageable);


    // ==========================================
    // 3. SEARCH & FILTERS
    // ==========================================

    @Query("SELECT u FROM User u WHERE " +
            "LOWER(u.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<User> searchUsers(@Param("keyword") String keyword, Pageable pageable);

    Page<User> findByCityOrState(String city, String state, Pageable pageable);

    List<User> findByCountry(String country);

    Optional<User> findByPhoneNumber(String phoneNumber);


    // ==========================================
    // 4. ADMIN & ANALYTICS
    // ==========================================

    @Query("SELECT u FROM User u WHERE u.lastActiveAt < :cutoffDate")
    List<User> findInactiveUsers(@Param("cutoffDate") LocalDateTime cutoffDate);

    long countByIsVerifiedTrue();

    @Query("SELECT SUM(u.walletBalance) FROM User u")
    Double sumTotalWalletBalance();

    @Query("SELECT u.itemsSold FROM User u WHERE u.id = :userId")
    int sumTotalItemsSoldByAUser(@Param("userId") UUID userId);

    @Query("SELECT u.itemsBought FROM User u WHERE u.id = :userId")
    int sumTotalItemsBoughtByAUser(@Param("userId") UUID userId);

    @Query("SELECT u.totalRewards FROM User u WHERE u.id = :userId")
    int sumTotalRewards(@Param("userId") UUID userId);

    long countByIsVerifiedFalse();


    // ==========================================
    // 5. BULK UPDATES (Use with caution)
    // ==========================================

    @Modifying
    @Query("UPDATE User u SET u.isVerified = true WHERE u.id = :userId")
    void verifyUser(@Param("userId") UUID userId);

    @Modifying
    @Query("UPDATE User u SET u.walletBalance = u.walletBalance + :amount WHERE u.id = :userId")
    void depositToWallet(@Param("userId") UUID userId, @Param("amount") double amount);

    @Modifying
    @Query("UPDATE User u SET u.lastActiveAt = :currentDate WHERE u.id = :userId")
    void updateLastActiveAt(@Param("userId") UUID userId, @Param("currentDate") LocalDateTime currentDate);

    @Modifying
    @Query("UPDATE User u SET u.itemsSold = u.itemsSold + 1 WHERE u.id = :userId")
    void updateItemsSold(@Param("userId") UUID userId);

    @Modifying
    @Query("UPDATE User u SET u.itemsBought = u.itemsBought + 1 WHERE u.id = :userId")
    void updateItemsBought(@Param("userId") UUID userId);

    @Modifying
    @Query("UPDATE User u SET u.walletBalance = u.walletBalance - :amount " +
            "WHERE u.id = :userId AND u.walletBalance >= :amount")
    int withdrawFromWallet(@Param("userId") UUID userId,@Param("ammount") double ammount);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.address = :address WHERE u.id = :userId")
    void updateAddress(@Param("userId") UUID userId,@Param("address") String address);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.profilePicUrl = :profilePicUrl WHERE u.id = :userId")
    void updateProfilePicUrl(@Param("userId") UUID userId,@Param("profilePicUrl") String profilePicUrl);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.phoneNumber = :phoneNumber WHERE u.id = :userId")
    void updatePhoneNumber(@Param("userId") UUID userId,@Param("phoneNumber") String phoneNumber);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.country = :country WHERE u.id = :userId")
    void updateCountry(@Param("userId") UUID userId,@Param("country") String country);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.state = :state WHERE u.id = :userId")
    void updateState(@Param("userId") UUID userId,@Param("state") String state);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.city = :city WHERE u.id = :userId")
    void updateCity(@Param("userId") UUID userId,@Param("city") String city);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.pinCode = :pinCode WHERE u.id = :userId")
    void updatePinCode(@Param("userId") UUID userId,@Param("pinCode") String pinCode);


}
