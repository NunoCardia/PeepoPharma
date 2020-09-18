package com.peepopharma.mapper;

import com.peepopharma.config.BaseMapperConfig;
import com.peepopharma.dto.PrescriptionDto;
import com.peepopharma.persistence.model.Prescription;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface PrescriptionMapper {

  Prescription fromPrescriptionDto(PrescriptionDto prescriptionDto);

  PrescriptionDto fromPrescription(Prescription prescription);

  List<PrescriptionDto> fromPrescriptionModelList(List<Prescription> prescriptionList);

}
