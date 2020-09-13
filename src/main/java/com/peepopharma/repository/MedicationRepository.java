package com.peepopharma.repository;

import com.peepopharma.model.Medication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends PagingAndSortingRepository<Medication, String> {

}
