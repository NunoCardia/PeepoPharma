package com.peepopharma.repository;

import com.peepopharma.model.Sale;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends PagingAndSortingRepository<Sale, String> {

}
