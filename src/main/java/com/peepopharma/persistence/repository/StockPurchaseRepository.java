package com.peepopharma.persistence.repository;

import com.peepopharma.persistence.model.StockPurchase;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPurchaseRepository extends PagingAndSortingRepository<StockPurchase, String> {

}
