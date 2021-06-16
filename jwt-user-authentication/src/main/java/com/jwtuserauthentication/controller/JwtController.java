package com.jwtuserauthentication.controller;

import com.jwtuserauthentication.entity.Coupon;
import com.jwtuserauthentication.entity.Deal;
import com.jwtuserauthentication.entity.User;
import com.jwtuserauthentication.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class JwtController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/username/{username}")
    public User getUserByUserName(@PathVariable("username") String userName) throws Exception {
        return this.customUserDetailsService.fetchUserByUserName(userName);
    }
    @PostMapping("/updateuser")
    public boolean updateUser(@RequestBody User user) throws Exception {
        return this.customUserDetailsService.updateUser(user);
    }
    @PostMapping("/updateuserpoints")
    public boolean updateUserPoints(@RequestBody User user) throws Exception {
        return this.customUserDetailsService.updateUserPoints(user);
    }

    @GetMapping("/allcoupon")
    public List<Coupon> getAllCoupons() throws Exception {
        List<Coupon> couponList= this.customUserDetailsService.fetchAllCoupons();
        return couponList;
    }
    @GetMapping("/alldeal")
    public List<Deal> getAllDeals() throws Exception {
        List<Deal> dealList= this.customUserDetailsService.fetchAllDeals();
        return dealList;
    }
}
