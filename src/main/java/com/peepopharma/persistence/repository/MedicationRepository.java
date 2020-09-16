package com.peepopharma.persistence.repository;

import com.peepopharma.persistence.model.Medication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends PagingAndSortingRepository<Medication, String> {

}
