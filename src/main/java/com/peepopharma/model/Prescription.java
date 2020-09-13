package com.peepopharma.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PP_PRESCRIPTION", indexes = {
    @Index(columnList = "ID, PRESCRIPTION_NUMBER")
})
@Data
@NoArgsConstructor
public class Prescription {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message = "Id cannot be null or empty")
  @Column(name = "PRESCRIPTION_ID", unique = true, updatable = false, nullable = false, length = 10)
  private String id;

  @NotBlank(message = "Medication number cannot be null or empty")
  @Pattern(regexp = "[A-Z0-9-_]+")
  @Column(name = "PRESCRIPTION_NUMBER", nullable = false)
  private String prescriptionNumber;

  @NotBlank(message = "Quantity cannot be null or empty")
  @Column(name = "QUANTITY", nullable = false)
  private Integer quantity;

  @OneToMany(
      targetEntity = Medication.class,
      mappedBy = "prescription",
      fetch = FetchType.LAZY,
      cascade = CascadeType.ALL
  )
  private List<Medication> medications;

  @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "CLIENT", referencedColumnName = "ID", nullable = false)
  private User client;

  @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "DOCTOR", referencedColumnName = "ID", nullable = false)
  private User doctor;

}