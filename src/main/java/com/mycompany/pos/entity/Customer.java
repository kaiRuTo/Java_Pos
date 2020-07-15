package com.mycompany.pos.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString(callSuper=true, includeFieldNames=true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    private Long id;

    @Column(name = "firstName", length = 512)
    @NotBlank
    private String firstName;

    @Column(name = "lastName", length = 512)
    @NotBlank
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
}
