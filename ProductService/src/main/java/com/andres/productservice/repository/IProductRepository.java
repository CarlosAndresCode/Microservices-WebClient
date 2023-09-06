package com.andres.productservice.repository;

import com.andres.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository extends MongoRepository<Product, String> {
}
