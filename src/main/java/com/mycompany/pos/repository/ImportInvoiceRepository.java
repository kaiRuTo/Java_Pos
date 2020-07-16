package com.mycompany.pos.repository;

import com.mycompany.pos.entity.ImportInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportInvoiceRepository extends JpaRepository<ImportInvoice, Long> {
}
