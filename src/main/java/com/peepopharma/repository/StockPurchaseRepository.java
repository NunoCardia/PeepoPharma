package com.peepopharma.repository;

import com.peepopharma.model.StockPurchase;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPurchaseRepository extends PagingAndSortingRepository<StockPurchase, String> {

}
