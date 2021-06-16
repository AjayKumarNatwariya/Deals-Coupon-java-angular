package com.deal.controller;

import com.deal.entity.Deal;
import com.deal.helper.Response;
import com.deal.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deal")
public class DealController {
    @Autowired
    private DealService dealService;

    @PostMapping("/adddeal")
    public Response saveUser(@RequestBody Deal deal){
        return this.dealService.addDeal(deal);
    }
    @GetMapping("/dealname/{dealname}")
    public Deal getDealByDealName(@PathVariable("dealname") String dealName){
        return this.dealService.fetchDealByDealName(dealName);
    }
    @GetMapping("/dealid/{dealid}")
    public Deal getDealByDealId(@PathVariable("dealid") Long dealId) {
        return this.dealService.fetchDealByDealId(dealId);
    }
    @GetMapping("/alldeals")
    public List<Deal> getAllDeals(){
        List<Deal> dealList=this.dealService.fetchAllDeals();
        return dealList;
    }
}
