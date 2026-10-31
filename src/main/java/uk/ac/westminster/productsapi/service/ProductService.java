package uk.ac.westminster.productsapi.service;


import org.springframework.stereotype.Service;
import uk.ac.westminster.productsapi.dto.DigitalProduct;
import uk.ac.westminster.productsapi.dto.Discountable;
import uk.ac.westminster.productsapi.dto.PhysicalProduct;
import uk.ac.westminster.productsapi.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;



    public List<Product> getAllProducts(){

        Product d1 = new DigitalProduct(nextId++,"image", 100000.0, "test.com", 100.0);

        Product p1 = new PhysicalProduct(nextId++, "Laptop", 200000.0, 1.0,"24 x 24" );
        products.add(d1);
        products.add(p1);



        return products;
    }

    public Product addProduct(Product product){

        product.setId(nextId++);
        products.add(product);

        return product;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }


    public void deleteProductById(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name))
                .toList();

    }

    public List<String> getAllSummaries(){

//        return products.stream().map(p -> p.getSummary()).toList();

//        return products.stream().map(Product::getSummary).toList();

        List<String> summaries = new ArrayList<>();
        for (Product p : products){
            summaries.add(p.getSummary());

            if (p instanceof Discountable d){
                d.applyDiscount(0.10);
            }
        }
        return summaries;
    }



}
