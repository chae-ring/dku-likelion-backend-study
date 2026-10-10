package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    Optional<Product> findById(Long id);

    Optional<Product> update(Long id, Product product);

    boolean delete(Long id);
}
