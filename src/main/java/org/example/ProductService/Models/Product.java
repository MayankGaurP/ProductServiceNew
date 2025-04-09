package org.example.ProductService.Models;

//import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class Product extends BaseModel{


    String ProductName;
    String ProductDescription;
    String Brand;
    String Model;
    String ProductImage;
    Integer ProductPrice;
    String ProductCategory;
    String Color;
    String Category;
    int discount;


}
