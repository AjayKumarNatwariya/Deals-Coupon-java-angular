package com.coupon.service;

import com.coupon.entity.Coupon;
import com.coupon.helper.Response;

import java.util.List;

public interface CouponService {
    public Coupon fetchCouponByCouponId(Long couponId);
    public Coupon fetchCouponByProductName(String productName);
    public List<Coupon> fetchAllCoupons();
    public Response addCoupon(Coupon coupon);
}
