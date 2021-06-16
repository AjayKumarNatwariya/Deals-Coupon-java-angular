package com.jwtuserauthentication.services;

import com.jwtuserauthentication.entity.Coupon;
import com.jwtuserauthentication.entity.CustomUserDetails;
import com.jwtuserauthentication.entity.Deal;
import com.jwtuserauthentication.entity.User;
import com.jwtuserauthentication.helper.Response;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CustomUserDetailsService {
    public Response signupUser(User u);
    public User fetchUserByUserId(Long userId);
    public User fetchUserByUserEmail(String email);
    public User fetchUserByUserName(String userName);
    public List<Coupon> fetchAllCoupons();
    public List<Deal> fetchAllDeals();
    public boolean updateUser(User user);
    public CustomUserDetails loadUserByUsername(String userName);
    public ResponseEntity<?> generateToken(User UserCredential);
    public boolean updateUserPoints(User user);
}
