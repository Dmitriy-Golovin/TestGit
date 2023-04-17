package com.product.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.product.products.dao.DaoProduct;
import com.product.products.enumm.Provider;
import com.product.products.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class Product {
    
    private final ProductService productService;

    @Autowired
    public Product(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("product", productService.getAllProduct());
        model.addAttribute("title", "Список товаров");
        return "product/list";
    }
    
    @GetMapping("/details/{id}")
    public String infoProduct(@PathVariable("id") int id, Model model) {
        com.product.products.models.Product productDetails = productService.getProductId(id);
        model.addAttribute("product", productDetails);
        model.addAttribute("title", "Товар: " + productDetails.getName());
        return "product/details";
    }

    // Данный метод позволяет отобразить представление с формой подабвления товара

    @GetMapping("/add")
    public String newProduct(Model model) {
        model.addAttribute("product", new com.product.products.models.Product());
        model.addAttribute("title", "Добавить товар");
        return "product/add";
    }

    // Данный метод позволяет принять данные с формы и сохранить товар в лист

    @PostMapping("/add")
    public String newProduct(@ModelAttribute("product") @Valid com.product.products.models.Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product/add";
        }

        productService.productAdd(product);
        return "redirect:/";
    }

    // Данный метод позволяет получить редактируемый продукт по id и вернуть форму редактирования продукта

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        com.product.products.models.Product productEdit = productService.getProductId(id);
        model.addAttribute("edit_product", productEdit);
        model.addAttribute("title", "Редактировать товар: " + productEdit.getName());
        return "product/edit";
    }

    // Данный метод позволяет принять редактируемый объект с формы и обновить информацион о редактируемом товаре

    @PostMapping("/edit/{id}")
    public String edit_Product(@ModelAttribute("edit_product") @Valid com.product.products.models.Product product, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()) {
            return "product/edit";
        }

        productService.productEdit(id, product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/";
    }
}
