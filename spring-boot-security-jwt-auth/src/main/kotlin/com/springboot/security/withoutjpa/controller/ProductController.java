package com.springboot.security.withoutjpa.controller;

import com.springboot.security.withoutjpa.model.Product;
import com.springboot.security.withoutjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prabhakar, @Date 07-10-2024
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getAllProducts(){
        return this.productService.getProducts();
    }

    @RequestMapping(value = "/getProductById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable int id){
        return this.productService.getProductById(id);
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseBody
    public Product addProduct(@RequestBody Product product){
        return this.productService.addProduct(product);
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
    @ResponseBody
    public Product updateProduct(@RequestBody Product product){
        return this.productService.updateProduct(product);
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@RequestParam int id){
        this.productService.deleteProduct(id);
    }


}
