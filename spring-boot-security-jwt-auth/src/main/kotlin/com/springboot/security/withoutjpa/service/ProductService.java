package com.springboot.security.withoutjpa.service;

import com.springboot.security.withoutjpa.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author prabhakar, @Date 07-10-2024
 */
@Service
public class ProductService {

    List<Product> products = new ArrayList<>(List.of(
            new Product(101,"Iphone",30000),
            new Product(102,"Laptop",40000),
            new Product(103, "AC",450000)
    ));

    public List<Product> getProducts(){
        return this.products;
    }

    public Product getProductById(int id){
        return this.products.stream().filter(x -> x.getId() == id).findFirst()
                .orElse(new Product(id,"No Item Found",0.));
    }

    public Product addProduct(Product product){
        this.products.add(product);
        if (this.products.contains(product)){
            return product;
        }
        else return new Product(product.getId(),"Product Not Added",0.0);
    }

    public Product updateProduct(Product product){
        Optional<Product> exist = this.products.stream().filter(x -> x.getId() == product.getId()).findFirst();

        if (exist.isPresent()){
            this.products.set(0,product);
            return product;
        }
        else return new Product(product.getId(),"Product Not Updated",0.0);
    }

    public void deleteProduct(int id){
        this.products.remove(products.stream().filter(x -> x.getId() == id).findFirst().get());
    }


}
