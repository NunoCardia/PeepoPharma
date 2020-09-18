package com.peepopharma.controller;

import com.peepopharma.dto.MedicationDto;
import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.exception.InvalidRequestParametersException;
import com.peepopharma.service.MedicationApiService;
import com.peepopharma.service.MedicationService;
import com.peepopharma.validator.Validator;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pharma-api/medicationManagement/v1/")
@Slf4j
public class MedicationManagementApiController implements MedicationManagementApi{

  private final MedicationService medicationService;
  private final Validator<MedicationDto> medicationValidator;

  public MedicationManagementApiController(
      MedicationApiService medicationService, Validator<MedicationDto> medicationValidator) {
    this.medicationService = medicationService;
    this.medicationValidator = medicationValidator;
  }

  @Override
  public ResponseEntity<MedicationDto> createMedication(@Valid MedicationDto medicationDto)
      throws InvalidRequestParametersException {
    medicationValidator.validate(medicationDto);
    MedicationDto medication = medicationService.createMedication(medicationDto);
    return new ResponseEntity<>(medication, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteMedication(String id) throws EntityNotFoundException {
    medicationService.deleteMedication(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<Page<MedicationDto>> listMedication(@Valid Integer offset,
      @Valid Integer limit) {
    Page<MedicationDto> medications = medicationService.listMedication(offset, limit);
    return new ResponseEntity<>(medications, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<MedicationDto> patchMedication(String id,
      @Valid MedicationDto medicationDto)
      throws InvalidRequestParametersException, EntityNotFoundException {
    medicationValidator.validate(medicationDto);
    MedicationDto medication = medicationService.updateMedication(id, medicationDto);
    return new ResponseEntity<>(medication, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<MedicationDto> listMedication(String id) throws EntityNotFoundException {
    MedicationDto medication = medicationService.listMedication(id);
    return new ResponseEntity<>(medication, HttpStatus.OK);
  }
}
