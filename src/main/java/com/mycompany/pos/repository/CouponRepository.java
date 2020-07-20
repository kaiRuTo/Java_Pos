package com.mycompany.pos.repository;

import com.mycompany.pos.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query(value = "SELECT c FROM Coupon c WHERE c.isUsed = TRUE AND c.expiryDate > CURRENT_TIME")
    List<Coupon> findAllAvailableCoupon();
}
