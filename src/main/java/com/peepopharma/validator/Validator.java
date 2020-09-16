package com.peepopharma.validator;

import com.peepopharma.dto.BaseModel;
import com.peepopharma.exception.InvalidRequestParametersException;

public interface Validator<T extends BaseModel> {

  void validate(T model) throws InvalidRequestParametersException;

}
