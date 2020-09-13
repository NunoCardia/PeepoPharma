package com.peepopharma.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "PP_MEDICATION", indexes = {
    @Index(columnList = "ID, MEDICATION_NUMBER")
})
@Data
@NoArgsConstructor
public class Medication implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotBlank(message = "Id cannot be null or empty")
  @Column(name = "MEDICATION_ID", unique = true, updatable = false, nullable = false, length = 10)
  private String id;

  @NotBlank(message = "Name cannot be null or empty")
  @Column(name = "NAME", nullable = false)
  private String name;

  @NotBlank(message = "Medication number cannot be null or empty")
  @Pattern(regexp = "[A-Z0-9-_]+")
  @Column(name = "MEDICATION_NUMBER", nullable = false)
  private String medicationNumber;

  @NotBlank(message = "Medication status cannot be null or empty")
  @Enumerated(EnumType.STRING)
  @Column(name = "MEDICATION_STATUS", nullable = false, columnDefinition = "varchar(20) check (medication_status in ('In stock', 'Out of stock', 'Ordered'))")
  private MedicationStatus medicationStatus;

  @NotBlank(message = "Price cannot be null or empty")
  @Pattern(regexp = "[0-9]{1,3}([,][0-9]{2})?[€]")
  @Column(name = "PRICE", nullable = false, precision = 5, scale = 2)
  private Float price;

  @NotBlank(message = "Quantity cannot be null or empty")
  @Column(name = "QUANTITY", nullable = false)
  private Integer quantity;

  @NotBlank(message = "Dosage cannot be null or empty")
  @Column(name = "DOSAGE", nullable = false)
  private String dosage;

  @ManyToOne(targetEntity = Prescription.class, optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "PRESCRIPTION_ID", referencedColumnName = "ID", nullable = false)
  private Prescription prescription;

  @ManyToOne(targetEntity = StockPurchase.class, optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "STOCK_PURCHASE_ID", referencedColumnName = "ID", nullable = false)
  private StockPurchase stockPurchase;

  @ManyToMany(targetEntity = Sale.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "SALE_ID", referencedColumnName = "ID", nullable = false)
  private List<Sale> sales;

  @CreatedDate
  @Column(name = "CREATED_DATE", nullable = false)
  private LocalDateTime createdDate;

  @LastModifiedDate
  @Column(name = "LAST_MODIFIED_DATE", nullable = false)
  private LocalDateTime lastModifiedDate;

  @Version
  @Column(name = "VERSIONED_LOCK", columnDefinition = "bigint DEFAULT 0", nullable = false)
  private int version;

}
