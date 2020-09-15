package com.peepopharma.validator;

import com.peepopharma.dto.dtoBaseModel;
import com.peepopharma.exception.InvalidRequestParametersException;

public interface Validator<T extends dtoBaseModel> {

  void validate(T model) throws InvalidRequestParametersException;

}
