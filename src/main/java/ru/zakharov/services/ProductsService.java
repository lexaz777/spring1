package ru.zakharov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zakharov.entities.Product;
import ru.zakharov.repositories.ProductsRepository;

import java.util.List;

@Component
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAllProducts() {
        return productsRepository.getProducts();
    }

    public Product getProductById(Long id) {
        return productsRepository.getProductById(id);
    }

    public void addProduct(Product product) {
        if (product == null) return;
        productsRepository.addProduct(product);
    }
}
