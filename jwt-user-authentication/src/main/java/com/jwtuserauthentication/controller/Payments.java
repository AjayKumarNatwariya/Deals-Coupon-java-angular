package com.jwtuserauthentication.controller;

import com.jwtuserauthentication.entity.Donation;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.*;

@RestController
@CrossOrigin("http://localhost:4200")
public class Payments {
    @PostMapping("/donate")
    public String donation(@RequestBody Donation donation) throws Exception {
        RazorpayClient razorpayClient=new RazorpayClient("rzp_test_XdG8siihP5e9wA","djeIms1g3Hpdz6VJipAzr8Qa");
        JSONObject options = new JSONObject();
        options.put("amount", donation.getAmount()*100);
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        Order order = razorpayClient.Orders.create(options);
        return order.toString();
    }
}
