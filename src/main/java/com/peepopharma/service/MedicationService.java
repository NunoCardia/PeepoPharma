package com.peepopharma.service;

import com.peepopharma.dto.MedicationDto;
import com.peepopharma.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;

public interface MedicationService {

    MedicationDto createMedication(MedicationDto medicationDto);

    void deleteMedication(String id) throws EntityNotFoundException;

    Page<MedicationDto> listMedication(Integer offset, Integer limit);

    MedicationDto updateMedication(String id, MedicationDto medicationDto)
        throws EntityNotFoundException;

    MedicationDto listMedication(String id) throws EntityNotFoundException;

}
