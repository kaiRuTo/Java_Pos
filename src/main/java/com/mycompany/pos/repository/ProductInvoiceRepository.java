package com.mycompany.pos.repository;

import com.mycompany.pos.entity.ProductInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice, Long> {
}
