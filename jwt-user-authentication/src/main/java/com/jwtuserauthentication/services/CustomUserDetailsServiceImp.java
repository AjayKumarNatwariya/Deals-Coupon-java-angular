package com.jwtuserauthentication.services;

import com.jwtuserauthentication.entity.*;
import com.jwtuserauthentication.helper.JwtUtil;
import com.jwtuserauthentication.helper.Response;
import com.jwtuserauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsServiceImp implements UserDetailsService,CustomUserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CustomUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = null;
        try {
            user = this.fetchUserByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CustomUserDetails(user);
    }

    public ResponseEntity<?> generateToken(User UserCredential){
        User user= this.fetchUserByUserName(UserCredential.getUserName());
        if(user!=null)
        {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(UserCredential.getUserName(), UserCredential.getPassword()));
        }else{
            return null;
        }
        System.out.println(UserCredential.getUserName());
        UserDetails userDetails = this.loadUserByUsername(UserCredential.getUserName());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("jtw " + token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @Override
    public Response signupUser(User userData){
        User user= this.fetchUserByUserName(userData.getUserName());
        System.out.println(user);
        System.out.println(userData);
        if (user==null) {
            userData.setPassword(bCryptPasswordEncoder.encode(userData.getPassword()));
            userData.setEnabled(true);
            userData.setRol("ROLE_USER");
            repository.save(userData);
            return new Response(userData.getUserName()+" added successful ",true);
        }
        return new Response(userData.getUserName()+" not added successful ",false);
    }

    @Override
    public boolean updateUser(User userData){
        User user= this.fetchUserByUserName(userData.getUserName());
        if (user!=null) {
            user.setPassword(bCryptPasswordEncoder.encode(userData.getPassword()));
            user.setLastName(userData.getLastName());
            user.setFirstName(userData.getFirstName());
            user.setEmail(userData.getEmail());
            repository.save(user);
            return true;
        }
        return false;
    }

    public boolean updateUserPoints(User userData){
        User user= this.fetchUserByUserName(userData.getUserName());
        if (user!=null) {
            user.setPoints(userData.getPoints());
            user.setCouponIdList(userData.getCouponIdList());
            user.setDealIdList(userData.getDealIdList());
            repository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User fetchUserByUserId(Long userId){
        return this.getUserCouponDeal(repository.findAll().stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null));
    }

    @Override
    public User fetchUserByUserEmail(String email){
        return this.getUserCouponDeal(repository.findAll().stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null));
    }

    public User fetchUserByUserName(String userName) {
        try
        {
            return this.getUserCouponDeal(repository.findAll().stream().filter(user -> user.getUserName().equals(userName)).findAny().orElse(null));
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Coupon> fetchAllCoupons() {
        List<Coupon> coupons=this.restTemplate.getForObject("http://coupon-service/coupon/allcoupons",List.class);
        return coupons;
    }

    @Override
    public List<Deal> fetchAllDeals() {
        List<Deal> deals=this.restTemplate.getForObject("http://deal-service/deal/alldeals",List.class);
        return deals;
    }

    private User getUserCouponDeal(User user){
        List<Long> couponIdList = user.getCouponIdList();
        List<Coupon> couponsList = new ArrayList<Coupon>();
        for(Long couponId:couponIdList) {
            couponsList.add(this.restTemplate.getForObject("http://coupon-service/coupon/couponid/"+couponId,Coupon.class));
        }
        user.setCouponsList(couponsList);
        List <Long> dealIdList = user.getDealIdList();
        List<Deal> DealsList = new ArrayList<Deal>();
        for(Long dealId:dealIdList) {
            DealsList.add(this.restTemplate.getForObject("http://deal-service/deal/dealid/"+dealId,Deal.class));
        }
        user.setDealsList(DealsList);
        return user;
    }
}
