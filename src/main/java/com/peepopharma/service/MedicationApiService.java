package com.peepopharma.service;

import com.peepopharma.dto.MedicationDto;
import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.persistence.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MedicationApiService implements MedicationService{

  @Override
  public MedicationDto createMedication(MedicationDto medicationDto) {
    return null;
  }

  @Override
  public void deleteMedication(String id) throws EntityNotFoundException {

  }

  @Override
  public Page<User> listMedication(Integer offset, Integer limit) {
    return null;
  }

  @Override
  public MedicationDto updateMedication(String id, MedicationDto MedicationDto)
      throws EntityNotFoundException {
    return null;
  }

  @Override
  public MedicationDto listMedication(String id) throws EntityNotFoundException {
    return null;
  }
}
