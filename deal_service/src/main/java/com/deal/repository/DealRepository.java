package com.deal.repository;

import com.deal.entity.Deal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DealRepository extends MongoRepository<Deal,Long> {
}
