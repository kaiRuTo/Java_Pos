package com.mycompany.pos.service;

import com.mycompany.pos.entity.Stock;
import com.mycompany.pos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> findAll() {return stockRepository.findAll();}

    public void delete(Stock stock) {stockRepository.delete(stock);}

    public void save(Stock stock) {stockRepository.save(stock);}
}
