package com.peepopharma.mapper;

import com.peepopharma.config.BaseMapperConfig;
import com.peepopharma.dto.MedicationDto;
import com.peepopharma.persistence.model.Medication;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface MedicationMapper {

  MedicationDto fromMedicationModel(Medication medication);

  Medication fromMedicationDto(MedicationDto medicationDto);

}
