package uk.ac.westminster.productsapi.dto;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(DigitalProduct.class),
        @JsonSubTypes.Type(PhysicalProduct.class)
})

public abstract class Product {

    private Long id;
    private String name;
    private Double price;

    public Product(){

    }

    public Product(Long id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;

    }

    public void setId(Long id){
        this.id = id;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public abstract String getSummary();



}
