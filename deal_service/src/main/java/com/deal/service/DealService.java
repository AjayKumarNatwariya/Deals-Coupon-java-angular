package com.deal.service;

import com.deal.entity.Deal;
import com.deal.helper.Response;

import java.util.List;

public interface DealService {
    public Response addDeal(Deal deal);
    public Deal fetchDealByDealId(Long dealId);
    public Deal fetchDealByDealName(String dealName);
    public List<Deal> fetchAllDeals();
}
