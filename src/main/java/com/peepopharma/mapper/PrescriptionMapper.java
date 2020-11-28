package com.peepopharma.mapper;

import com.peepopharma.config.BaseMapperConfig;
import com.peepopharma.dto.PrescriptionDto;
import com.peepopharma.persistence.model.Prescription;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = BaseMapperConfig.class)
public interface PrescriptionMapper {

    Prescription fromPrescriptionDto(PrescriptionDto prescriptionDto);

    PrescriptionDto fromPrescription(Prescription prescription);

    List<PrescriptionDto> fromPrescriptionModelList(List<Prescription> prescriptionList);

}
