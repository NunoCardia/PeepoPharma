package com.peepopharma.repository;

import com.peepopharma.model.Prescription;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends PagingAndSortingRepository<Prescription, String> {

}
