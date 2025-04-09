package org.example.ProductService.Controller;


import org.example.ProductService.DTO.ProductDTO;
import org.example.ProductService.Models.Product;
import org.example.ProductService.Models.Product1;
import org.example.ProductService.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/hello")
  public String Helloworld(){

      return "Hello World";

    }
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        Product product = new Product();
        product.setId(2L);
        product.setProductName("Iphone");
        List<Product> productslist = new ArrayList<>();
        productslist.add(product);
        return  productslist;
    }

    @GetMapping("{productID}")
    public Product Returnproduct(@PathVariable Long productID){

        Product product = productService.getProduct(productID);
        return product;

    }
     @PostMapping("/add")
    public ProductDTO Returnproduct(@RequestBody Product product){

        ProductDTO product1 = productService.AddProduct(product);
        return product1;

    }

    @PostMapping("/add1")
    public ProductDTO Returnproduct(@RequestBody Product1 product){

//        ProductDTO product1 = productService.AddProduct(product);
        return null;

    }


}
