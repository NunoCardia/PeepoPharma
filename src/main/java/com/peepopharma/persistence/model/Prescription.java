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
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "PP_PRESCRIPTION", indexes = {
    @Index(columnList = "PRESCRIPTION_ID, PRESCRIPTION_NUMBER")
})
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null or empty")
    @Column(name = "PRESCRIPTION_ID", unique = true, updatable = false, nullable = false, length = 10)
    private Long id;

    @NotNull(message = "Medication number cannot be null or empty")
    @Pattern(regexp = "[A-Z0-9-_]+")
    @Column(name = "PRESCRIPTION_NUMBER", nullable = false)
    private String prescriptionNumber;

    @NotNull(message = "Quantity cannot be null or empty")
    @Pattern(regexp = "[0-9]+")
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @OneToMany(
        mappedBy = "prescription",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    private List<Medication> medications;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT", referencedColumnName = "USER_ID", nullable = false)
    private User client;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCTOR", referencedColumnName = "USER_ID", nullable = false)
    private User doctor;

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
