package com.peepopharma.validator;

import com.peepopharma.dto.UserDto;
import com.peepopharma.exception.ErrorMessage;
import com.peepopharma.exception.InvalidRequestParametersException;
import com.peepopharma.persistence.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
@Slf4j
public class UserValidator implements Validator<UserDto> {

    private static final String EMAIL_REGEX_EXP = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}";
    private static final String PHONE_NUMBER_REGEX_EXP = "^([+][(]?[0-9]{3}[)]?)?[0-9]{9}";

    @Override
    public void validate(UserDto model) throws InvalidRequestParametersException {
        if (!validateEmail(model.getEmail()) || !validateRole(model.getRole()) ||
            !validatePhoneNumber(model.getPhoneNumber())) {
            throw new InvalidRequestParametersException(ErrorMessage.INVALID_REQUEST_PARAMS);
        }
    }

    private boolean validateEmail(String email) {
        return Pattern.matches(EMAIL_REGEX_EXP, email);
    }

    private boolean validateRole(String role) {
        return Role.fromValue(role) != null;
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER_REGEX_EXP, phoneNumber);
    }
}
