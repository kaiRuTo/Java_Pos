package com.mycompany.pos.service;

import com.mycompany.pos.entity.ImportInvoice;
import com.mycompany.pos.entity.Stock;
import com.mycompany.pos.repository.ImportInvoiceRepository;
import com.mycompany.pos.repository.ProductRepository;
import com.mycompany.pos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImportInvoiceService {

    private ImportInvoiceRepository importInvoiceRepository;
    private StockRepository stockRepository;

    @Autowired
    public ImportInvoiceService(ImportInvoiceRepository importInvoiceRepository, StockRepository stockRepository) {
        this.importInvoiceRepository = importInvoiceRepository;
        this.stockRepository = stockRepository;
    }

    public List<ImportInvoice> findAll() {return importInvoiceRepository.findAll();}

    public void delete(ImportInvoice importInvoice) {importInvoiceRepository.delete(importInvoice);}

    public void save(ImportInvoice importInvoice) {importInvoiceRepository.save(importInvoice);}

    @Transactional
    public void confirmArrived(ImportInvoice importInvoice) {
        Optional<Stock> s = stockRepository.findByProduct(importInvoice.getProduct());
        if(s.isPresent()) {
            Long quantity = s.get().getQuantity();
            s.get().setQuantity(quantity + importInvoice.getQuantity());
            s.get().setUpdatedAt(new Date());
            stockRepository.save(s.get());
        }
        else {
            Stock stock = new Stock();
            stock.setProduct(importInvoice.getProduct());
            stock.setUpdatedAt(new Date());
            stock.setQuantity(importInvoice.getQuantity());
            stockRepository.save(stock);
        }
    }
}
