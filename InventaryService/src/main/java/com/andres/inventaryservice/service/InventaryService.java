package com.andres.inventaryservice.service;

import com.andres.inventaryservice.repository.IInventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class InventaryService {

    private final IInventoryRepository repository;


    public InventaryService(IInventoryRepository repository) {
        this.repository = repository;
    }

    public Boolean isInStock(String skuCode) {
        return this.repository.findBySkuCode(skuCode).isPresent();
    }
}
