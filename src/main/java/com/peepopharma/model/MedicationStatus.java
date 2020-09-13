package com.peepopharma.model;

import lombok.Getter;

public enum MedicationStatus {

  IN_STOCK("In stock"),
  OUT_STOCK("Out of stock"),
  ORDERED("Ordered");


  @Getter
  private final String value;

  MedicationStatus(String value) {
    this.value = value;
  }

  public static MedicationStatus fromValue(String value) {
    for (MedicationStatus action : MedicationStatus.values()) {
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
