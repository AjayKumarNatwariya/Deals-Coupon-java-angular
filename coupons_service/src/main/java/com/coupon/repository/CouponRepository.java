package com.coupon.repository;

import com.coupon.entity.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CouponRepository extends MongoRepository<Coupon,Long> {
}
