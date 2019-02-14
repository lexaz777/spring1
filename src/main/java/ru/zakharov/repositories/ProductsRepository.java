package ru.zakharov.repositories;

import org.springframework.stereotype.Component;
import ru.zakharov.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products = new ArrayList<>();

    public Product getProductById(Long id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
