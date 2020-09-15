package com.peepopharma.validator;

import com.peepopharma.dto.User;
import com.peepopharma.exception.ErrorMessage;
import com.peepopharma.exception.InvalidRequestParametersException;
import com.peepopharma.model.Role;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserValidator implements Validator<User> {

  public static final String EMAIL_REGEX_EXP = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}";
  public static final String PHONE_NUMBER_REGEX_EXP = "^([+][(]?[0-9]{3}[)]?)?[0-9]{9}";

  @Override
  public void validate(User model) throws InvalidRequestParametersException {
    if (!validateEmail(model.getEmail()) || !validateRole(model.getRole()) ||
        !validatePhoneNumber(model.getPhoneNumber())){
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
