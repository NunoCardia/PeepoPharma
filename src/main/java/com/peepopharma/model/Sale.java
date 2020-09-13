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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PP_SALE", indexes = {
    @Index(columnList = "ID")
})
@Data
@NoArgsConstructor
public class Sale {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message = "Id cannot be null or empty")
  @Column(name = "SALE_ID", unique = true, updatable = false, nullable = false, length = 10)
  private String id;

  @NotBlank(message = "Quantity cannot be null or empty")
  @Column(name = "QUANTITY", nullable = false)
  private Integer quantity;

  @NotBlank(message = "Price cannot be null or empty")
  @Pattern(regexp = "[0-9]{1,3}([,][0-9]{2})?[€]")
  @Column(name = "PRICE", nullable = false, precision = 5, scale = 2)
  private Float price;

  @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "CLIENT", referencedColumnName = "ID", nullable = false)
  private User client;

  @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "PHARMACEUTIST", referencedColumnName = "ID", nullable = false)
  private User pharmaceutist;

  @ManyToMany(targetEntity = Medication.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "MEDICATION_ID", referencedColumnName = "ID", nullable = false)
  private List<Medication> medications;

}
