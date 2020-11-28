package com.peepopharma.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "PP_USER", indexes = {
    @Index(columnList = "USER_ID, CITIZEN_CARD,VAT")
})
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id cannot be null or empty")
    @Column(name = "USER_ID", unique = true, updatable = false, nullable = false, length = 10)
    private Long id;

    @NotNull(message = "Name cannot be null or empty")
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull(message = "Email cannot be null or empty")
    @Pattern(regexp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}")
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @NotNull(message = "Address cannot be null or empty")
    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @NotNull(message = "Citizen card cannot be null or empty")
    @Column(name = "CITIZEN_CARD", nullable = false, unique = true)
    private String citizenCard;

    @NotNull(message = "VAT cannot be null or empty")
    @Column(name = "VAT", nullable = false, unique = true)
    private String vat;

    @NotNull(message = "Phone Number cannot be null or empty")
    @Pattern(regexp = "^([+][(]?[0-9]{3}[)]?)?[0-9]{9}")
    @Column(name = "PHONE_NUMBER", nullable = false, length = 13)
    private String phoneNumber;

    @NotNull(message = "Status cannot be null or empty")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 15,
        columnDefinition = "varchar(20) check (status in ('ADMIN', 'PHARMACEUTIST', 'CLIENT', 'DOCTOR'))")
    private Role role;

    @OneToOne(optional = false, mappedBy = "admin")
    private StockPurchase stockPurchase;

    @OneToOne(optional = false, mappedBy = "client")
    private Sale clientSale;

    @OneToOne(optional = false, mappedBy = "pharmaceutist")
    private Sale pharmaceutistSale;

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
