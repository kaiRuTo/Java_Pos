package com.mycompany.pos.service;

import com.mycompany.pos.entity.Supplier;
import com.mycompany.pos.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAll() {return supplierRepository.findAll();}

    public void delete(Supplier supplier) {supplierRepository.delete(supplier);}

    public Supplier save(Supplier supplier) { return supplierRepository.save(supplier);}
}
