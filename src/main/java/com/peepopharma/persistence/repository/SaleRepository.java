package com.peepopharma.persistence.repository;

import com.peepopharma.persistence.model.Sale;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends PagingAndSortingRepository<Sale, String> {

}
