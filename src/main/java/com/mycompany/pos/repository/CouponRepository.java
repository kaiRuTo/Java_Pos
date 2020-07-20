package com.mycompany.pos.repository;

import com.mycompany.pos.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query(value = "SELECT * FROM coupon c WHERE c.is_used = true AND c.expiry_date > CURRENT_TIME")
    List<Coupon> findAllAvailableCoupon();
}
