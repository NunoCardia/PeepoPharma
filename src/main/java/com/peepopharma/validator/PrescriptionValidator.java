package com.peepopharma.validator;

import com.peepopharma.dto.PrescriptionDto;
import com.peepopharma.exception.ErrorMessage;
import com.peepopharma.exception.InvalidRequestParametersException;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class PrescriptionValidator implements Validator<PrescriptionDto>{

  private static final String PRESCRIPTION_NUMBER_REGEX_EXP = "[A-Z0-9-_]+";
  private static final String QUANTITY_REGEX_EXP = "[0-9]+";
  @Override
  public void validate(PrescriptionDto model) throws InvalidRequestParametersException {
    if (!validatePrescriptionNumber(model.getPrescriptionNumber()) ||
        !validateQuantity(model.getQuantity())){
      throw new InvalidRequestParametersException(ErrorMessage.INVALID_REQUEST_PARAMS);
    }
  }

  private boolean validatePrescriptionNumber(String prescriptionNumber) {
    return Pattern.matches(PRESCRIPTION_NUMBER_REGEX_EXP, prescriptionNumber);
  }

  private boolean validateQuantity(Integer quantity) {
    return Pattern.matches(QUANTITY_REGEX_EXP, String.valueOf(quantity));
  }
}
