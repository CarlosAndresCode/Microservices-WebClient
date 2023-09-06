package com.andres.inventaryservice.controller;

import com.andres.inventaryservice.service.InventaryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    private final InventaryService service;


    public InventoryController(InventaryService service) {
        this.service = service;
    }

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable String skuCode){
        return service.isInStock(skuCode);
    }
}
