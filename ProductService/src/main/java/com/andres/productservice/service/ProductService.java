package com.andres.productservice.service;

import com.andres.productservice.dto.ProductRequest;
import com.andres.productservice.dto.ProductResponse;
import com.andres.productservice.model.Product;
import com.andres.productservice.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor Con esta notation no evitamos crear el constructor
@Slf4j
public class ProductService {

    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    public void createProducto(ProductRequest productRequest){

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());


        repository.save(product);
        log.info("Product with ID: " + product.getId() + " created");
    }

    public Optional<ProductResponse> getByIdProducto(String id){

        Optional<Product> product = repository.findById(id);

        if (product.isPresent()){
            ProductResponse response = mapToProductResponse(product.get());
            return Optional.of(response);
        }else{
            return Optional.of(new ProductResponse());
        }
    }
    public List<ProductResponse> getAllProduct() {
        List<Product> products = this.repository.findAll();
        return  products.stream().map(this::mapToProductResponse).toList();
    }
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
