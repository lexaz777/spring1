package ru.zakharov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.zakharov.entities.Product;
import ru.zakharov.repositories.ProductsPageableRepository;
import ru.zakharov.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;
    private ProductsPageableRepository productsPageableRepository;

    @Autowired
    public void setProductsPageableRepository(ProductsPageableRepository productsPageableRepository) {
        this.productsPageableRepository = productsPageableRepository;
    }

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productsRepository.findProductById(id);
    }

    public void addProduct(Product product) {
        if (product == null) return;
        productsRepository.save(product);
    }

    public List<Product> getProductsByPriceRange(int min, int max) {
        return productsRepository.findProductsByPriceBetween(min,max);
    }

    public List<Product> getProductsByPriceRangeAndPage(Pageable pageable,int min, int max) {
        return productsPageableRepository.findProductsByPriceBetween(min,max,pageable);
    }

    public int getCountOfProducts() {
        return productsRepository.findAll().size();
    }


}
