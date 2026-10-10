package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.respository.ProductRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        Product newProduct = new Product(product.getProductName(), product.getPrice());
        return productRepository.save(newProduct);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> update(Long id, Product request) {
        return productRepository.findById(id).map(product -> {
            product.setProductName(request.getProductName());
            product.setPrice(request.getPrice());
            return productRepository.save(product);
        });
    }

    @Override
    public boolean delete(Long id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
}
