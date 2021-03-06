package com.peepopharma.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PP_STOCK_PURCHASES", indexes = {
    @Index(columnList = "STOCK_PURCHASE_ID")
})
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class StockPurchase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null or empty")
    @Column(name = "STOCK_PURCHASE_ID", unique = true, updatable = false, nullable = false, length = 10)
    private Long id;

    @NotNull(message = "Name cannot be null or empty")
    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @OneToMany(
        targetEntity = Medication.class,
        mappedBy = "stockPurchase",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    private List<Medication> medications;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STOCK_PURCHASE_ADMIN", referencedColumnName = "USER_ID", nullable = false)
    private User admin;

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
