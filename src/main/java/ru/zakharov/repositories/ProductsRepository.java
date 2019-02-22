package ru.zakharov.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import ru.zakharov.entities.Product;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Product,Long> {
    public Product findProductById(Long id);
    public List<Product> findProductsByPriceBetween(int min,int max);
    public List<Product> findAll();
}
