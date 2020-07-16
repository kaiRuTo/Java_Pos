package com.mycompany.pos.service;

import com.mycompany.pos.entity.ImportInvoice;
import com.mycompany.pos.repository.ImportInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportInvoiceService {
    private ImportInvoiceRepository importInvoiceRepository;

    @Autowired
    public ImportInvoiceService(ImportInvoiceRepository importInvoiceRepository) {
        this.importInvoiceRepository = importInvoiceRepository;
    }

    public List<ImportInvoice> findAll() {return importInvoiceRepository.findAll();}

    public void delete(ImportInvoice importInvoice) {importInvoiceRepository.delete(importInvoice);}

    public void save(ImportInvoice importInvoice) {importInvoiceRepository.save(importInvoice);}
}
