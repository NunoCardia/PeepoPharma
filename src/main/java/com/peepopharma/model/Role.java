package com.peepopharma.model;

import lombok.Getter;

public enum Role {
  ADMIN("Admin"),
  PHARMACEUTIST("Pharmaceutist"),
  CLIENT("Client"),
  DOCTOR("Doctor");

  @Getter
  private final String value;

  Role(String value) {
    this.value = value;
  }

  public static Role fromValue(String value) {
    for (Role action : Role.values()) {
      if (action.getValue().equalsIgnoreCase(value)) {
        return action;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }


}
