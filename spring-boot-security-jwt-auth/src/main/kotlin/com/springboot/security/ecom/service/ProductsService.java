package com.springboot.security.ecom.service;

import com.springboot.security.ecom.model.Products;
import com.springboot.security.ecom.repository.ProductsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author prabhakar, @Date 07-10-2024
 */
@Service
public class ProductsService {

    private final ProductsRepository repository;


    public ProductsService(ProductsRepository repository) {
        this.repository = repository;
    }


    public List<Products> getAllProducts() {
        return this.repository.findAll();
    }


    public Products getProductById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Products addProduct(Products product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return repository.save(product);
    }

    public Products updateProduct(String id, Products product, MultipartFile imageFile) throws IOException {
        product.setImageDate(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repository.save(product);
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }

    public List<Products> searchProducts(String keyword) {
        return repository.searchProducts(keyword);
    }


}
