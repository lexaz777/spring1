package ru.zakharov.controllers;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zakharov.entities.Product;
import ru.zakharov.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/list")
    public String showAllProducts(Model model, @RequestParam int page) {
        model.addAttribute("products", productsService.getAllProducts());
        return "product-list";
    }

    @RequestMapping("/add")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

//    @GetMapping
//    public String filterProductsByPrice(Model model, @RequestParam int min, @RequestParam int max) {
//        List<Product> filteredProducts = null;
//        if (min >= 0 && max >= 0) {
//            filteredProducts = productsService.getProductsByPriceRange(min, max);
//        }
//
//        model.addAttribute("products", filteredProducts);
//
//        return "product-list";
//    }

    @GetMapping
    public String filterProductsByPriceAndPage(Model model, @RequestParam int min, @RequestParam int max, @RequestParam int page) {
        List<Product> filteredProducts = null;
        if (min >= 0 && max >= 0 && page >= 0) {
            filteredProducts = productsService.getProductsByPriceRangeAndPage(PageRequest.of(page, 5), min, max);
        }

        int totalPages = productsService.getCountOfProducts() / 5;

        List<Integer> allPages = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            allPages.add(i);
        }


        model.addAttribute("products", filteredProducts);
        model.addAttribute("allPages", allPages);

        return "product-list";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        System.out.println(product.getTitle() + " " + product.getId());
        productsService.addProduct(product);
        return "product-list";
    }

}
