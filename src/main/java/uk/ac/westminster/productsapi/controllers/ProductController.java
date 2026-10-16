package uk.ac.westminster.productsapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uk.ac.westminster.productsapi.dto.Product;
import uk.ac.westminster.productsapi.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name){
        return productService.findByName(name);
    }













//    private final List<Product> products = new ArrayList<>();
//
//
//    @GetMapping()
//    public List<Product>  getProducts(){
//        return products;
//    }
//
//    @GetMapping("/{id}")
//    public Product getProduct(@PathVariable Long id){
//
//        for (Product product : products ){
//            if (product.getId().equals(id)){
//                return product;
//            }
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found");
//
//
//    }
//
//
//    @PostMapping()
//    public Product addProduct(@RequestBody Product product){
//
//        for (Product p : products){
//            if (p.getId().equals(product.getId())){
//                throw new ResponseStatusException(HttpStatus.CONFLICT, "Product Id is already registered");
//            }
//        }
//
//        products.add(product);
//        return product;
//    }



}
