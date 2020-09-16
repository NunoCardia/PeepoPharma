package com.peepopharma.persistence.repository;

import com.peepopharma.persistence.model.Prescription;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends PagingAndSortingRepository<Prescription, String> {

}
