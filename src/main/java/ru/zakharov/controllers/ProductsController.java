package ru.zakharov.controllers;


import org.springframework.web.bind.annotation.ModelAttribute;
import ru.zakharov.entities.Product;
import ru.zakharov.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/list")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productsService.getAllProducts());
        return "product-list";
    }

    @RequestMapping("/add")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }


    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        System.out.println(product.getTitle() + " " + product.getId());
        productsService.addProduct(product);
        return "product-list";
    }

}
