package com.peepopharma.persistence.model;

import java.time.LocalDateTime;
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
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

  @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "CLIENT", referencedColumnName = "ID", nullable = false)
  private User client;

  @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
  @JoinColumn(name = "PHARMACEUTIST", referencedColumnName = "ID", nullable = false)
  private User pharmaceutist;

  @ManyToMany(targetEntity = Medication.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "MEDICATION_ID", referencedColumnName = "ID", nullable = false)
  private List<Medication> medications;

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
