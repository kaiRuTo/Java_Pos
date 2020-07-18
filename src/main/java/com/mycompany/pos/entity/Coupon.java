package com.mycompany.pos.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coupon")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString(includeFieldNames=true)
public class Coupon {
    @Id
    @ToString.Exclude
    private String idCoupon;

    @ManyToOne
    @JoinColumn(name = "id_orders")
    private Orders orders;

    private Boolean isUsed;
    
    private float discountPercentage;

    private Date expiryDate;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
}
