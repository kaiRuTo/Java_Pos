package com.mycompany.pos.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "invoice")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString(includeFieldNames=true)
public class ProductInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    @Column(name = "id_product_invoice")
    private Long idProductInvoice;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "vat")
    private BigDecimal vat;

    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
}
