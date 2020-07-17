package com.mycompany.pos.service;

import com.mycompany.pos.entity.ProductInvoice;
import com.mycompany.pos.repository.ProductInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInvoiceService {
    private ProductInvoiceRepository productInvoiceRepository;

    @Autowired
    public ProductInvoiceService(ProductInvoiceRepository productInvoiceRepository) {
        this.productInvoiceRepository = productInvoiceRepository;
    }

    public List<ProductInvoice> findAll() {return productInvoiceRepository.findAll();}

    public void delete(ProductInvoice productInvoice) {
        productInvoiceRepository.delete(productInvoice);}

    public void save(ProductInvoice productInvoice) {
        productInvoiceRepository.save(productInvoice);}
}
