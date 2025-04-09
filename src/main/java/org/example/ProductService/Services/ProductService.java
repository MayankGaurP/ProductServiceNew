package org.example.ProductService.Services;

import org.example.ProductService.DTO.ProductDTO;
import org.example.ProductService.DTO.fakestoreDTO;
import org.example.ProductService.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired
RestTemplateBuilder builder;


    public Product getProduct(Long productID) {
        fakestoreDTO productResponseEntity = builder.build().getForObject("https://fakestoreapi.in/api/products/{productID}",fakestoreDTO.class, productID);
        System.out.println(productResponseEntity);
        return from(productResponseEntity.getProduct());
    }

    public ProductDTO AddProduct(Product product) {
        ProductDTO productDTO = from1(product);
        fakestoreDTO response = builder.build().postForEntity("https://fakestoreapi.in/api/products",productDTO, fakestoreDTO.class).getBody();
        System.out.println(response);
        return response.getProduct();

    }

    public ProductDTO from1(Product product) {
        ProductDTO productDTO = new ProductDTO();
//        productDTO.setID(product.getId());
        productDTO.setTitle(product.getProductName());
        productDTO.setBrand(product.getBrand());
        productDTO.setModel(product.getModel());
        productDTO.setColor(product.getColor());
        productDTO.setCategory(product.getCategory());
        productDTO.setDiscount(product.getDiscount());


        return productDTO;}



    public Product from(ProductDTO productDto) {
        Product product = new Product();
        product.setId((long)productDto.getId());
        product.setProductName(productDto.getTitle());
//        product.setProductDescription(productDto.getDescription());
//        product.setProductPrice(productDto.getPrice());
//        product.setProductImage(productDto.getImage());
////        Category category = new Category();
////        category.setName(fakeStoreProductDto.getCategory());
////        product.setCategory(category);
        return product;
    }
}
