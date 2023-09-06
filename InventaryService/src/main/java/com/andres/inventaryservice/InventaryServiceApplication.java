package com.andres.inventaryservice;

import com.andres.inventaryservice.model.Inventory;
import com.andres.inventaryservice.repository.IInventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventaryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventaryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(IInventoryRepository repository){
        return  args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphon_13");
            inventory.setQuantity(100);

            Inventory inventory2 = new Inventory();
            inventory2.setSkuCode("iphon_12");
            inventory2.setQuantity(0);

            repository.save(inventory);
            repository.save(inventory2);

        };
    }
}
