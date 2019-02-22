package ru.zakharov.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.zakharov.entities.Product;

import java.util.List;

@Repository
public interface ProductsPageableRepository extends PagingAndSortingRepository<Product,Long> {
    public List<Product> findProductsByPriceBetween(int min, int max, Pageable pageable);
}
