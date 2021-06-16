package com.deal.service;
import com.deal.repository.DealRepository;
import com.deal.entity.Deal;
import com.deal.helper.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealServiceImpl implements DealService{
    @Autowired
    private DealRepository repository;

    @Override
    public Response addDeal(Deal deal){
        repository.save(deal);
        return new Response(deal.getDealName()+" deal added successful",true);
    }
    @Override
    public Deal fetchDealByDealId(Long dealId) {
        return repository.findAll().stream().filter(deal -> deal.getDealId().equals(dealId)).findAny().orElse(null);
    }

    @Override
    public Deal fetchDealByDealName(String dealName) {
        return repository.findAll().stream().filter(deal -> deal.getDealName().equals(dealName)).findAny().orElse(null);
    }

    @Override
    public List<Deal> fetchAllDeals() {
        return repository.findAll();
    }
}