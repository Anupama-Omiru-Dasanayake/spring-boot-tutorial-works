package uk.ac.westminster.productsapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uk.ac.westminster.productsapi.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();


    @GetMapping()
    public List<Product>  getProducts(){
        return products;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){

        for (Product product : products ){
            if (product.getId().equals(id)){
                return product;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found");


    }


    @PostMapping()
    public Product addProduct(@RequestBody Product product){

        for (Product p : products){
            if (p.getId().equals(product.getId())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Product Id is already registered");
            }
        }

        products.add(product);
        return product;
    }



}
