package com.mycompany.pos.service;

import com.mycompany.pos.entity.Coupon;
import com.mycompany.pos.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    private CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<Coupon> findAll() {return couponRepository.findAll();}
    
    public void delete(Coupon coupon) {couponRepository.delete(coupon);}

    public void save(Coupon coupon) {couponRepository.save(coupon);}
}
