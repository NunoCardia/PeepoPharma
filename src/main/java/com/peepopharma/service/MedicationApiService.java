package com.peepopharma.service;

import com.peepopharma.dto.MedicationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MedicationApiService implements MedicationService {

  @Override
  public MedicationDto createMedication(MedicationDto medicationDto) {
    return null;
  }

  @Override
  public void deleteMedication(String id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Page<MedicationDto> listMedication(Integer offset, Integer limit) {
    return null;
  }

  @Override
  public MedicationDto updateMedication(String id, MedicationDto medicationDto) {
    return null;
  }

  @Override
  public MedicationDto listMedication(String id) {
    return null;
  }
}
