package com.peepopharma.validator;

import com.peepopharma.dto.MedicationDto;
import com.peepopharma.exception.ErrorMessage;
import com.peepopharma.exception.InvalidRequestParametersException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@Slf4j
public class MedicationValidator implements Validator<MedicationDto> {

    private static final String MEDICATION_NUMBER_REGEX_EXP = "[A-Z0-9-_]+";
    private static final String PRICE_REGEX_EXP = "[0-9]{1,3}([,][0-9]{2})?[€]";
    private static final String QUANTITY_REGEX_EXP = "[0-9]+";

    @Override
    public void validate(MedicationDto model) throws InvalidRequestParametersException {
        if (!validateMedicationNumber(model.getMedicationNumber()) || !validatePrice(model.getPrice())
            || !validateQuantity(model.getQuantity())) {
            throw new InvalidRequestParametersException(ErrorMessage.INVALID_REQUEST_PARAMS);
        }
    }

    private boolean validateMedicationNumber(String medicationNumber) {
        return Pattern.matches(MEDICATION_NUMBER_REGEX_EXP, medicationNumber);
    }

    private boolean validatePrice(Float price) {
        return Pattern.matches(PRICE_REGEX_EXP, String.valueOf(price));
    }

    private boolean validateQuantity(Integer quantity) {
        return Pattern.matches(QUANTITY_REGEX_EXP, String.valueOf(quantity));
    }
}
