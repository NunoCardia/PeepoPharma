package com.peepopharma.model;

import java.io.Serializable;
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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PP_STOCK_PURCHASES", indexes = {
    @Index(columnList = "ID")
})
@Data
@NoArgsConstructor
public class StockPurchase implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message = "Id cannot be null or empty")
  @Column(name = "STOCK_PURCHASE_ID", unique = true, updatable = false, nullable = false, length = 10)
  private String id;

  @NotBlank(message = "Name cannot be null or empty")
  @Column(name = "COMPANY_NAME", nullable = false)
  private String companyName;

  @NotBlank(message = "Price cannot be null or empty")
  @Pattern(regexp = "[0-9]{1,3}([,][0-9]{2})?[€]")
  @Column(name = "PRICE", nullable = false, precision = 5, scale = 2)
  private Float price;

  @NotBlank(message = "Quantity cannot be null or empty")
  @Column(name = "QUANTITY", nullable = false)
  private Integer quantity;

  @OneToMany(
      targetEntity = Medication.class,
      mappedBy = "stockPurchase",
      fetch = FetchType.LAZY,
      cascade = CascadeType.ALL
  )
  private List<Medication> medications;

  @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "ADMIN", referencedColumnName = "ID", nullable = false)
  private User admin;

}
