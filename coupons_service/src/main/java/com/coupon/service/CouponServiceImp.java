package com.coupon.service;

import com.coupon.helper.Response;
import com.coupon.repository.CouponRepository;
import com.coupon.entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImp implements CouponService {
    @Autowired
    private CouponRepository repository;

    @Override
    public Response addCoupon(Coupon coupon){
        repository.save(coupon);
        return new Response(coupon.getProductName()+" inserted",Boolean.TRUE);
    }
    @Override
    public Coupon fetchCouponByCouponId(Long couponId) {
        return repository.findAll().stream().filter(coupon -> coupon.getCouponId().equals(couponId)).findAny().orElse(null);
    }
    @Override
    public Coupon fetchCouponByProductName(String productName) {
        return repository.findAll().stream().filter(coupon -> coupon.getProductName()==(productName)).findAny().orElse(null);
    }
    @Override
    public List<Coupon> fetchAllCoupons() {
        return repository.findAll();
    }
}
