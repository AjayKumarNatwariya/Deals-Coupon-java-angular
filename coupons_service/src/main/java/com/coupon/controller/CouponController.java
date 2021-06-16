package com.coupon.controller;

import com.coupon.entity.Coupon;
import com.coupon.helper.Response;
import com.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping("/addcoupon")
    public Response saveCoupon(@RequestBody Coupon coupon){
        return this.couponService.addCoupon(coupon);
    }
    @GetMapping("/allcoupons")
    public List<Coupon> getAllCoupon(){
        List<Coupon> couponList =  this.couponService.fetchAllCoupons();
        return couponList;
    }
    @GetMapping("/productname/{productname}")
    public Coupon getCouponByProductName(@PathVariable("productname") String productName){
        Coupon coupon = this.couponService.fetchCouponByProductName(productName);
        return coupon;
    }
    @GetMapping("/couponid/{couponid}")
    public Coupon getCouponByCouponId(@PathVariable("couponid") Long couponId){
        Coupon coupon = this.couponService.fetchCouponByCouponId(couponId);
        return coupon;
    }
}